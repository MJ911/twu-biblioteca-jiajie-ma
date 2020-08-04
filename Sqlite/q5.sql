SELECT member.name, count(checkout_item.member_id) 
FROM checkout_item, member
WHERE member.id = checkout_item.member_id
GROUP BY checkout_item.member_id
HAVING count(checkout_item.member_id) > 2