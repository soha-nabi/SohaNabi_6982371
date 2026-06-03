USE community_portal;

SELECT
u.full_name,
COUNT(e.event_id)
AS total_events
FROM Users u
LEFT JOIN Events e
ON u.user_id=e.organizer_id
GROUP BY u.user_id,u.full_name;