CREATE TABLE PUBLIC.books
(
  id long auto_increment,
  isbn varchar(13) not null,
  title varchar(128) not null,
  author varchar(128),
  page_number int,

  primary key(id)
);

INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 991, '0142437964', 'In Search of Lost Time', 'Marcel Proust', 468 );
INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 992, '1840226358', 'Ulysses', 'James Joyce', 736 );
INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 993, '0142437239', 'Don Quixote', 'Miguel de Cervantese', 1072 );
INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 994, '0060883286', 'One Hundred Years of Solitude', 'Gabriel Garcia Marquez', 417 );
INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 995, '9780743273565', 'The Great Gatsby', 'F. Scott Fitzgerald', 180 );
INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 996, '1853260088', 'Moby Dick', 'Herman Melville', 544 );
INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 997, '1400079985', 'War and Peace', 'Leo Tolstoy', 1296 );
INSERT INTO PUBLIC.books(id, isbn, title, author, page_number) VALUES ( 998, '9780743477123', 'Hamlet', 'William Shakespeare', 342 );