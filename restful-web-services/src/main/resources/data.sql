CREATE DATABASE TestDatabase;
USE TestDatabase;

CREATE TABLE Todo (
	id				INT	UNSIGNED	NOT NULL,
	username 	VARCHAR(30),
	description	VARCHAR(1000),
	targetDate	DATE,
	isDone		BOOLEAN,
	PRIMARY KEY (id)
);
CREATE TABLE Students (
	StudentID	INT(7)	UNSIGNED	NOT NULL,
	Given_Name	VARCHAR(250),
	Family_Name	VARCHAR(250),
	Display_Name	VARCHAR(30),
	PRIMARY KEY (StudentID)
);
CREATE TABLE WallPosts (
	PostID		INT(13)	UNSIGNED	NOT NULL,
	OwnerID		INT(7)	UNSIGNED	NOT NULL,
	Creation_Time	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,
	Modified_Time	TIMESTAMP	ON UPDATE CURRENT_TIMESTAMP,
	Message		MEDIUMTEXT,
	Edited		BOOLEAN DEFAULT FALSE,
	Deleted		BOOLEAN DEFAULT FALSE,
	PRIMARY KEY (PostID),
	FOREIGN KEY (OwnerID) REFERENCES Students(StudentID)
);
CREATE TABLE WallComments (
	CommentID	INT(17)	UNSIGNED	NOT NULL,
	ParentID	INT(13)	UNSIGNED	NOT NULL,
	AuthorID		INT(7)	UNSIGNED	NOT NULL,
	Creation_Time	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,
	Modified_Time	TIMESTAMP	ON UPDATE CURRENT_TIMESTAMP,
	Message		TEXT(4000),
	Edited		BOOLEAN DEFAULT FALSE,
	Deleted		BOOLEAN DEFAULT FALSE,
	PRIMARY KEY (CommentID),
	FOREIGN KEY (ParentID) REFERENCES WallPosts(PostID),
	FOREIGN KEY (AuthorID) REFERENCES Students(StudentID)
);

INSERT INTO Students (StudentID, Given_Name, Family_Name, Display_Name)
VALUES (3689650, 'Jonathan Luke', 'Herriot Ware', 'Jon Ware');
INSERT INTO Students (StudentID, Given_Name, Family_Name, Display_Name)
VALUES (3664099, 'David', 'Sarkies', 'David');
INSERT INTO Students (StudentID, Given_Name, Family_Name, Display_Name)
VALUES (3735236, 'Raphael Doh Ong', 'Wong', 'Raphael');
INSERT INTO Students (StudentID, Given_Name, Family_Name, Display_Name)
VALUES (3691487, 'Yanying', 'Xu', 'Jasmine');

INSERT INTO WallPosts (PostID, OwnerID, Message)
VALUES (1, 3691487, 'Ultricies integer quis auctor elit sed vulputate mi. Sed velit dignissim sodales ut eu sem integer vitae justo. Tristique risus nec feugiat in fermentum posuere urna nec tincidunt. Pulvinar elementum integer enim neque volutpat ac tincidunt vitae semper. Dignissim convallis aenean et tortor at. At quis risus sed vulputate odio. Eu mi bibendum neque egestas congue quisque egestas diam. Tortor at auctor urna nunc id cursus metus aliquam. Enim diam vulputate ut pharetra sit amet aliquam id. Ultrices gravida dictum fusce ut placerat orci nulla pellentesque. Mauris rhoncus aenean vel elit scelerisque mauris pellentesque. Aliquet nec ullamcorper sit amet risus nullam eget. Blandit volutpat maecenas volutpat blandit aliquam etiam erat. Tempus egestas sed sed risus pretium quam. Et malesuada fames ac turpis.');
INSERT INTO WallPosts (PostID, OwnerID, Message)
VALUES (2, 3664099, 'Id consectetur purus ut faucibus pulvinar elementum integer enim. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec. Ut morbi tincidunt augue interdum. Leo integer malesuada nunc vel risus commodo viverra. Senectus et netus et malesuada. Ullamcorper sit amet risus nullam eget felis. Convallis aenean et tortor at risus viverra adipiscing at. Dictum sit amet justo donec enim diam. Tincidunt ornare massa eget egestas purus viverra. Proin libero nunc consequat interdum varius sit amet mattis vulputate. Et ultrices neque ornare aenean euismod elementum nisi. Tempor orci eu lobortis elementum nibh tellus. Sed vulputate odio ut enim blandit.');
INSERT INTO WallPosts (PostID, OwnerID, Message)
VALUES (3, 3735236, 'Volutpat blandit aliquam etiam erat velit scelerisque in dictum. Commodo ullamcorper a lacus vestibulum sed. In aliquam sem fringilla ut morbi tincidunt augue interdum velit. Arcu non odio euismod lacinia at quis risus. Ullamcorper velit sed ullamcorper morbi tincidunt ornare. Purus non enim praesent elementum facilisis leo vel. Et ultrices neque ornare aenean euismod elementum nisi quis. Sodales neque sodales ut etiam sit. Velit egestas dui id ornare. Senectus et netus et malesuada fames ac turpis egestas maecenas. Lacus vestibulum sed arcu non odio euismod lacinia.');
INSERT INTO WallPosts (PostID, OwnerID, Message)
VALUES (4, 3689650, 'Leo vel orci porta non pulvinar neque. Integer eget aliquet nibh praesent tristique magna sit. Sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae. Amet nisl suscipit adipiscing bibendum est ultricies. Semper feugiat nibh sed pulvinar proin gravida. Tristique magna sit amet purus gravida quis. Viverra nam libero justo laoreet sit amet cursus sit. Odio pellentesque diam volutpat commodo sed egestas egestas. Vivamus at augue eget arcu dictum. Gravida cum sociis natoque penatibus. Venenatis cras sed felis eget. Id ornare arcu odio ut sem nulla pharetra diam sit. Tellus in hac habitasse platea dictumst. Posuere lorem ipsum dolor sit amet consectetur adipiscing elit. Pellentesque sit amet porttitor eget dolor morbi non arcu. In eu mi bibendum neque egestas congue. Egestas dui id ornare arcu odio ut sem nulla pharetra. Iaculis nunc sed augue lacus viverra vitae congue eu consequat. At elementum eu facilisis sed odio morbi. Sollicitudin nibh sit amet commodo nulla facilisi.');
INSERT INTO WallPosts (PostID, OwnerID, Message)
VALUES (5, 3691487, 'Mollis aliquam ut porttitor leo. Felis donec et odio pellentesque diam volutpat commodo sed. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi. Fermentum leo vel orci porta non pulvinar neque laoreet. Leo in vitae turpis massa sed elementum tempus egestas sed. Erat pellentesque adipiscing commodo elit at. Ultricies leo integer malesuada nunc vel risus. Pharetra vel turpis nunc eget lorem dolor. Vel turpis nunc eget lorem dolor sed. Et netus et malesuada fames ac. Et sollicitudin ac orci phasellus egestas. Maecenas sed enim ut sem viverra aliquet. Gravida arcu ac tortor dignissim convallis. Lectus magna fringilla urna porttitor rhoncus dolor purus non enim. Non tellus orci ac auctor augue mauris augue neque gravida. Id aliquet risus feugiat in ante metus dictum. Id semper risus in hendrerit.');

INSERT INTO WallComments (CommentID, ParentID, AuthorID, Message)
VALUES (1, 1, 3689650, 'Lectus mauris ultrices eros in cursus turpis massa.');
INSERT INTO WallComments (CommentID, ParentID, AuthorID, Message)
VALUES (2, 1, 3664099, 'Arcu odio ut sem nulla pharetra. Purus faucibus ornare suspendisse sed.');
INSERT INTO WallComments (CommentID, ParentID, AuthorID, Message)
VALUES (3, 1, 3735236, 'Urna et pharetra pharetra massa massa. Eu tincidunt tortor aliquam nulla facilisi.');

INSERT INTO Todo(id, username,description,target_date,is_done)
VALUES(10001, 'sept', 'Learn JPA', sysdate(), false);
INSERT INTO Todo(id, username,description,target_date,is_done)
VALUES(10002, 'sept', 'Learn Data JPA', sysdate(), false);
INSERT INTO Todo(id, username,description,target_date,is_done)
VALUES(10003, 'sept', 'Learn Microservices', sysdate(), FALSE);
