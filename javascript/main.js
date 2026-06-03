console.log('Welcome to the Community Portal')
document.addEventListener('DOMContentLoaded',()=>{alert('Page fully loaded');init()})
const exampleEventName='Community Picnic'
const exampleEventDate='2026-06-20'
let exampleSeats=50
console.log(`Event: ${exampleEventName} on ${exampleEventDate} - Seats: ${exampleSeats}`)
class EventClass{
  constructor(id,name,date,seats,category,location,description){
    this.id=id
    this.name=name
    this.date=new Date(date)
    this.seats=seats
    this.category=category
    this.location=location
    this.description=description
  }
  checkAvailability(){
    return this.seats>0 && this.date>new Date()
  }
}
function logEntries(ev){
  const entries=Object.entries(ev)
  console.log(entries)
}
let events=[]
function addEvent(ev){
  events.push(ev)
  renderEvents(events)
  populateEventSelect()
}
async function registerUser(eventId,user){
  try{
    const ev=events.find(e=>e.id===eventId)
    if(!ev) throw new Error('Event not found')
    if(!(ev.date>new Date())) throw new Error('Event is in the past')
    if(ev.seats<=0) throw new Error('No seats available')
    ev.seats--
    renderEvents(events)
    const payload={eventId,user}
    const res=await mockPostRegistration(payload)
    return res
  }catch(err){
    console.error('Registration error',err)
    throw err
  }
}
function mockPostRegistration(payload){
  return new Promise((resolve,reject)=>{
    setTimeout(()=>{if(Math.random()>0.05)resolve({status:'ok',payload});else reject(new Error('Network error'))},800)
  })
}
function filterEventsByCategory(category,callback){
  const list=category==='all'?events:events.filter(e=>e.category===category)
  return list.filter(callback)
}
function makeCategoryTracker(category){
  let total=0
  return {register:()=>++total,getTotal:()=>total,category}
}
function dynamicFilter(predicate){
  return events.filter(predicate)
}
function renderEvents(list){
  const container=document.querySelector('#events')
  if(!container) return
  container.innerHTML=''
  list.forEach(ev=>{
    if(!(ev.date>new Date())||ev.seats<=0) return
    const card=document.createElement('div')
    card.className='card'
    const title=document.createElement('h3')
    title.textContent=ev.name
    const date=document.createElement('p')
    date.textContent=`Date: ${ev.date.toLocaleDateString()}`
    const seats=document.createElement('p')
    seats.textContent=`Seats: ${ev.seats}`
    const category=document.createElement('p')
    category.textContent=`Category: ${ev.category}`
    const location=document.createElement('p')
    location.textContent=`Location: ${ev.location}`
    const desc=document.createElement('p')
    desc.textContent=ev.description
    const regBtn=document.createElement('button')
    regBtn.textContent='Register'
    regBtn.onclick=async ()=>{
      const name=prompt('Your name')
      const email=prompt('Your email')
      if(name&&email){
        try{await registerUser(ev.id,{name,email});alert('Registered')}
        catch(e){alert('Registration failed')}
      }
    }
    const cancelBtn=document.createElement('button')
    cancelBtn.textContent='Cancel'
    cancelBtn.onclick=()=>{ev.seats++;renderEvents(events)}
    card.append(title,date,seats,category,location,desc,regBtn,cancelBtn)
    container.appendChild(card)
  })
}
function populateEventSelect(){
  const sel=document.querySelector('#eventSelect')
  if(!sel) return
  sel.innerHTML=''
  events.filter(e=>e.date>new Date()&&e.seats>0).forEach(e=>{
    const opt=document.createElement('option')
    opt.value=e.id
    opt.textContent=`${e.name} (${e.date.toLocaleDateString()})`
    sel.appendChild(opt)
  })
}
async function fetchEvents(){
  const spinner=document.querySelector('#spinner')
  spinner&&spinner.classList.remove('hidden')
  return fetch('data/events.json').then(r=>r.json()).then(data=>{spinner&&spinner.classList.add('hidden');return data}).catch(err=>{spinner&&spinner.classList.add('hidden');console.error(err);return[]})
}
async function fetchEventsAsync(){
  const spinner=document.querySelector('#spinner')
  spinner&&spinner.classList.remove('hidden')
  try{
    const res=await fetch('data/events.json')
    const data=await res.json()
    spinner&&spinner.classList.add('hidden')
    return data
  }catch(e){
    spinner&&spinner.classList.add('hidden')
    console.error(e)
    return []
  }
}
function initEventHandlers(){
  const categoryFilter=document.querySelector('#categoryFilter')
  categoryFilter&&categoryFilter.addEventListener('change',e=>{const val=e.target.value;const list=val==='all'?events:events.filter(x=>x.category===val);renderEvents(list)})
  const searchInput=document.querySelector('#searchInput')
  searchInput&&searchInput.addEventListener('keydown',e=>{if(e.key==='Enter'){const q=e.target.value.toLowerCase();renderEvents(events.filter(ev=>ev.name.toLowerCase().includes(q)))}})
  const form=document.querySelector('#regForm')
  form&&form.addEventListener('submit',async e=>{
    e.preventDefault()
    const name=form.elements.name.value.trim()
    const email=form.elements.email.value.trim()
    const eventId=form.elements.eventId.value
    console.log('Submitting',name,email,eventId)
    if(!name||!email||!eventId){alert('Please fill all fields');return}
    try{await registerUser(eventId,{name,email});alert('Registration successful')}catch(err){alert('Registration failed')}
  })
  $('#registerBtn').click(()=>{$('#formSection').fadeIn()})
}
function seedEvents(data){
  data.forEach(d=>{const ev=new EventClass(d.id,d.name,d.date,d.seats,d.category,d.location,d.description);events.push(ev)})
  renderEvents(events)
  populateEventSelect()
}
async function init(){
  const data=await fetchEvents()
  if(Array.isArray(data)&&data.length>0)seedEvents(data)
  initEventHandlers()
  const tracker=makeCategoryTracker('Music')
  const musicEvents=events.filter(e=>e.category==='Music')
  const musicNames=musicEvents.map(e=>e.name)
  const cloned=[...events]
  console.log(musicNames,cloned)
  if(events.length===0){addEvent(new EventClass('1','Workshop on Baking','2026-07-10',20,'Workshop','Community Center','Learn baking'))
    addEvent(new EventClass('2','Summer Concert','2026-08-01',150,'Music','Central Park','Live bands'))
    addEvent(new EventClass('3','Neighborhood Meetup','2026-06-25',30,'Meetup','Library','Meet neighbors'))}
  logEntries(events[0]||{})
}