INSERT INTO book VALUES(11, "The Pragmatic Programmer");
INSERT INTO member VALUES(43, "Jiajie Ma");
INSERT INTO checkout_item VALUES(43, 11, NULL);
SELECT member.name FROM member 
WHERE member.id in (
	SELECT checkout_item.member_id from checkout_item, book
	WHERE book.id = checkout_item.book_id 
	AND book.title = "The Pragmatic Programmer"
)
