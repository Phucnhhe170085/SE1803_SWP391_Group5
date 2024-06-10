INSERT INTO room (roomFloor, roomNumber, roomSize, roomFee, roomImg)
VALUES 
    (1, 101, 1, 100, './Image/room/room1.jpg'),
    (1, 102, 2, 150, './Image/room/room2.jpg'),
    (1, 103, 3, 200, './Image/room/room3.jpg'),
    (1, 104, 1, 100, './Image/room/room4.jpg'),
    (1, 105, 2, 150, './Image/room/room5.jpg'),
    (2, 201, 2, 150, './Image/room/room6.jpg'),
    (2, 202, 3, 200, './Image/room/room7.jpg'),
    (2, 203, 1, 100, './Image/room/room8.jpg'),
    (2, 204, 1, 100, './Image/room/room9.jpg'),
    (2, 205, 2, 150, './Image/room/room10.jpg'),
    (3, 301, 3, 200, './Image/room/room11.jpg'),
    (3, 302, 1, 100, './Image/room/room12.jpg'),
    (3, 303, 2, 150, './Image/room/room13.jpg'),
    (3, 304, 2, 150, './Image/room/room14.jpg'),
    (3, 305, 3, 200, './Image/room/room15.jpg'),
    (4, 401, 1, 100, './Image/room/room16.jpg'),
    (4, 402, 3, 200, './Image/room/room17.jpg'),
    (4, 403, 1, 100, './Image/room/room18.jpg'),
    (4, 404, 2, 150, './Image/room/room19.jpg'),
    (4, 405, 3, 200, './Image/room/room20.jpg');

	INSERT INTO item (itemName, itemImg)
VALUES
    ('Chair', './Image/item/chair.jpg'),
    ('Table', './Image/item/table.jpg'),
    ('Single Bed', './Image/item/single_bed.jpg'),
    ('Fan', './Image/item/fan.jpg'),
    ('Desk Lamp', './Image/item/desk_lamp.jpg'),
    ('Bookshelf', './Image/item/bookshelf.jpg'),
    ('Wardrobe', './Image/item/wardrobe.jpg'),
    ('Curtains', './Image/item/curtains.jpg'),
    ('TV', './Image/item/tv.jpg'),
    ('Sofa', './Image/item/sofa.jpg');


INSERT INTO roomItem (roomID, itemID, quantity)
VALUES 
    (1, 1, 3), (1, 2, 2), (1, 3, 1), (1, 4, 4), (1, 5, 2),
    (2, 1, 2), (2, 3, 3), (2, 5, 1), (2, 6, 2), (2, 8, 2),
    (3, 2, 3), (3, 4, 2), (3, 6, 1), (3, 7, 3), (3, 9, 2),
    (4, 3, 2), (4, 5, 1), (4, 7, 1), (4, 8, 3), (4, 10, 2),
    (5, 1, 3), (5, 2, 2), (5, 3, 1), (5, 4, 4), (5, 5, 2),
    (6, 1, 3), (6, 2, 2), (6, 3, 1), (6, 4, 4), (6, 5, 2),
    (7, 1, 2), (7, 3, 3), (7, 5, 1), (7, 6, 2), (7, 8, 2),
    (8, 2, 3), (8, 4, 2), (8, 6, 1), (8, 7, 3), (8, 9, 2),
    (9, 3, 2), (9, 5, 1), (9, 7, 1), (9, 8, 3), (9, 10, 2),
    (10, 1, 3), (10, 2, 2), (10, 3, 1), (10, 4, 4), (10, 5, 2),
    (11, 1, 2), (11, 3, 3), (11, 5, 1), (11, 6, 2), (11, 8, 2),
    (12, 2, 3), (12, 4, 2), (12, 6, 1), (12, 7, 3), (12, 9, 2),
    (13, 3, 2), (13, 5, 1), (13, 7, 1), (13, 8, 3), (13, 10, 2),
    (14, 1, 3), (14, 2, 2), (14, 3, 1), (14, 4, 4), (14, 5, 2),
    (15, 1, 2), (15, 3, 3), (15, 5, 1), (15, 6, 2), (15, 8, 2),
    (16, 2, 3), (16, 4, 2), (16, 6, 1), (16, 7, 3), (16, 9, 2),
    (17, 3, 2), (17, 5, 1), (17, 7, 1), (17, 8, 3), (17, 10, 2),
    (18, 1, 3), (18, 2, 2), (18, 3, 1), (18, 4, 4), (18, 5, 2),
    (19, 1, 2), (19, 3, 3), (19, 5, 1), (19, 6, 2), (19, 8, 2),
    (20, 2, 3), (20, 4, 2), (20, 6, 1), (20, 7, 3), (20, 9, 2);





INSERT INTO account ( userMail, userPassword, userRole)
VALUES
    ('maingoctu@gmail.com', 'pass1234', 1),
    ('nguyenhuong@gmail.com', 'pass1234', 1),
    ('phamvannam@gmail.com', 'pass1234', 1),
    ('tranlananh@gmail.com', 'pass1234', 1),
    ('levanduy@gmail.com', 'pass1234', 1),
    ('nguyenthimai@gmail.com', 'pass1234', 1),
    ('hoangvanlong@gmail.com', 'pass1234', 1),
    ('dothihang@gmail.com', 'pass1234', 1),
    ('vuvantuan@gmail.com', 'pass1234', 1),
    ('nguyenvananh@gmail.com', 'pass1234', 1),
    ('phanvanhung@gmail.com', 'pass1234', 1),
    ('buithihang@gmail.com', 'pass1234', 1),
    ('travanhung@gmail.com', 'pass1234', 1),
    ('dangthiha@gmail.com', 'pass1234', 1),
    ('nguyenvanlinh@gmail.com', 'pass1234', 2),
    ('nguyenthihong@gmail.com', 'pass1234', 2),
    ('levanquan@gmail.com', 'pass1234', 2),
    ('tranthithu@gmail.com', 'pass1234', 2),
    ('phamvankhoi@gmail.com', 'pass1234', 3),
    ('admin@gmail.com', 'admin123', 4),
	('hoatt@gmail.com', 'password123', 0),
    ('binhnv@gmail.com', 'password123', 0),
    ('lanpt@gmail.com', 'password123', 0),
    ('haile@gmail.com', 'password123', 0),
    ('loannt@gmail.com', 'password123', 0),
    ('hoatd@gmail.com', 'password123', 0),
    ('ngankn@gmail.com', 'password123', 0),
    ('tuanntm@gmail.com', 'password123', 0),
    ('thaottt@gmail.com', 'password123', 0),
    ('minhvp@gmail.com', 'password123', 0);


	INSERT INTO [user] (userID,userName, userGender, userBirth, userAddress, userPhone, userAvatar)
VALUES
    (1,N'Mai Ngọc Tú', 'Male', '2002-05-15', N'180 Phố Vọng, Thanh Xuân, Hà Nội', '0987654321', './Image/user/avatar1.jpg'),
    (2,N'Vu Duy Hung', 'Female', '2002-10-20', N'56 Lê Lợi, Quận 1, Thành phố Hồ Chí Minh', '0981234567', './Image/user/avatar2.jpg'),
    (3,N'Phạm Quang Thắng', 'Male', '2002-03-02', N'39 Lê Hồng Phong, TP. Hải Phòng', '0976543210', './Image/user/avatar3.jpg'),
    (4,N'Trần Thị Lan Anh', 'Female', '2003-12-10', N'105 Trần Phú, TP. Vinh, Nghệ An', '0965432109', './Image/user/avatar4.jpg'),
    (5,N'Lê Văn Duy', 'Male', '2003-08-25', N'30 Đại Cồ Việt, Hai Bà Trưng, Hà Nội', '0932109876', './Image/user/avatar5.jpg'),
    (6,N'Nguyễn Thị Mai', 'Female', '2003-06-18', N'15 Hoàng Cầu, Đống Đa, Hà Nội', '0943210987', './Image/user/avatar6.jpg'),
    (7,N'Hoàng Văn Long', 'Male', '2003-02-28', N'70 Lê Duẩn, Hoàn Kiếm, Hà Nội', '0910987654', './Image/user/avatar7.jpg'),
    (8,N'Đỗ Thị Hằng', 'Female', '2004-09-07', N'45 Lý Thường Kiệt, Hà Tĩnh', '0921098765', './Image/user/avatar8.jpg'),
    (9,N'Vũ Văn Tuấn', 'Male', '2005-11-12', N'112 Lý Thường Kiệt, Hà Tĩnh', '0909876543', './Image/user/avatar9.jpg'),
    (10,N'Nguyễn Vân Anh', 'Other', '2005-07-22', N'5 Hàng Bài, Hoàn Kiếm, Hà Nội', '0998765432', './Image/user/avatar10.jpg'),
    (11,N'Phan Văn Hùng', 'Male', '2005-04-03', N'51 Nguyễn Thái Học, Cà Mau', '0954321098', './Image/user/avatar11.jpg'),
    (12,N'Bùi Thị Hằng', 'Female', '2005-01-30', N'36 Trần Nhân Tông, Hải Dương', '0912345678', './Image/user/avatar12.jpg'),
    (13,N'Trần Văn Hùng', 'Male', '2000-08-14', N'35 Lê Thánh Tông, Hoàn Kiếm, Hà Nội', '0987654321', './Image/user/avatar13.jpg'),
    (14,N'Đặng Thị Hà', 'Other', '2000-03-17', N'80 Lê Lai, TP. Biên Hòa, Đồng Nai', '0987654321', './Image/user/avatar14.jpg'),
    (15,N'Nguyễn Văn Linh', 'Male', '1991-12-05', N'100 Hai Bà Trưng, Hoàn Kiếm, Hà Nội', '0987654321', './Image/user/avatar15.jpg'),
    (16,N'Nguyễn Hoàng Hồng', 'Male', '1987-05-25', N'92 Điện Biên Phủ, Lào Cai', '0987654321', './Image/user/avatar16.jpg'),
    (17,N'Lê Văn Quân', 'Male', '1985-09-12', N'18 Trần Phú, Ba Đình, Hà Nội', '0987654321', './Image/user/avatar17.jpg'),
    (18,N'Trần Thị Thu', 'Female', '1996-11-30', N'42 Trần Phú, Nam Định', '0987654321', './Image/user/avatar18.jpg'),
    (19,N'Phạm Văn Khôi', 'Male', '1986-02-08', N'20 Lý Thường Kiệt, Hoàn Kiếm, Hà Nội', '0987654321', './Image/user/avatar19.jpg'),
    (20,N'Admin', 'Unknown', '1989-07-18', 'Unknown', '0987654321', './Image/user/avatar20.jpg'),
	(21,N'Trần Thị Hoa', 'Female', '1990-08-10', N'30 Đường Lê Lợi, Hai Bà Trưng, Hà Nội', '0987654321', './Image/user/avatar21.jpg'),
    (22,N'Nguyễn Văn Bình', 'Male', '1994-06-05', N'40 Phố Huế, Hai Bà Trưng, Hà Nội', '0987654322', './Image/user/avatar22.jpg'),
    (23,N'Phạm Thị Lan', 'Female', '1998-02-18', N'50 Hàng Bài, Hoàn Kiếm, Hà Nội', '0987654323', './Image/user/avatar23.jpg'),
    (24,N'Lê Văn Hải', 'Male', '2000-12-25', N'60 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội', '0987654324', './Image/user/avatar24.jpg'),
    (25,N'Nguyễn Thị Loan', 'Female', '1996-10-03', N'70 Trần Phú, Ba Đình, Hà Nội', '0987654325', './Image/user/avatar25.jpg'),
    (26,N'Trần Đức Hòa', 'Male', '1992-04-15', N'80 Bà Triệu, Hai Bà Trưng, Hà Nội', '0987654326', './Image/user/avatar26.jpg'),
    (27,N'Lê Thị Kim Ngân', 'Female', '1993-07-20', N'90 Lê Duẩn, Hai Bà Trưng, Hà Nội', '0987654327', './Image/user/avatar27.jpg'),
    (28,N'Nguyễn Minh Tuấn', 'Male', '1988-09-28', N'100 Hàng Bài, Hoàn Kiếm, Hà Nội', '0987654328', './Image/user/avatar28.jpg'),
    (29,N'Trần Thị Thanh Thảo', 'Female', '1991-11-17', N'110 Hàng Điếu, Hoàn Kiếm, Hà Nội', '0987654329', './Image/user/avatar29.jpg'),
    (30,N'Phạm Văn Minh', 'Male', '1985-05-30', N'120 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội', '0987654330', './Image/user/avatar30.jpg');
	-- Generating data for renter table
INSERT INTO renter (userID, roomID, renterStatus, renterHaveRoom, CGRScore, balance)
VALUES
    (1, 1, 1, 1, 750, 1500.00),
    (2, 2, 1, 1, 800, 1800.00),
    (3, 3, 1, 1, 700, 2000.00),
    (4, 4, 1, 1, 850, 2200.00),
    (5, 5, 1, 1, 900, 2400.00),
    (6, 6, 1, 1, 750, 1500.00),
    (7, 7, 1, 1, 800, 1800.00),
    (8, 8, 1, 1, 700, 2000.00),
    (9, 9, 1, 1, 850, 2200.00),
    (10, 10, 1, 1, 900, 2400.00),
    (11, 11, 1, 1, 750, 1500.00),
    (12, 12, 1, 1, 800, 1800.00),
    (13, 13, 1, 1, 700, 2000.00),
    (14, 14, 1, 1, 850, 2200.00);

-- Generating data for security table
INSERT INTO [security] (userID, sShift, seStatus)
VALUES
    (15, 1, 1),
    (16, 1, 1),
    (17, 0, 1),
    (18, 0, 1);

-- Generating data for rule table
INSERT INTO [rule] (ruleName, img, scoreChange, penMoney)
VALUES
    ('No Smoking', './Image/rule/rule1.jpg', -10, 100.000),
    ('Quiet Hours', './Image/rule//rule2.jpg', -5, 50.000),
    ('No Pets Allowed', './Image/rule//rule3.jpg', -15, 150.000),
    ('Visitor Restrictions', './Image/rule//rule4.jpg', -10, 80.000);

INSERT INTO penalty(reportID, accuseID, roomID, [description], penDate, ruleID, penStatus)
VALUES
    (1, 2, 1, 'Smoking in the room', '2022-01-15 10:30:00', 1, 1),
    (2, 3, 2, 'Making excessive noise', '2022-01-17 09:45:00', 2, 1),
    (3, 4, 3, 'Keeping a pet in the room', '2022-01-19 14:20:00', 3, 1),
    (4, 5, 4, 'Having unauthorized visitors after hours', '2022-01-21 16:00:00', 4, 1),
    (5, 6, 5, 'Smoking in the room', '2022-01-25 11:10:00', 1, 1),
    (6, 7, 6, 'Making excessive noise', '2023-01-27 08:30:00', 2, 1),
    (7, 8, 7, 'Keeping a pet in the room', '2023-01-29 13:45:00', 3, 1),
    (8, 9, 8, 'Having unauthorized visitors after hours', '2023-01-31 15:20:00', 4, 1),
    (9, 10, 9, 'Smoking in the room', '2023-02-04 10:00:00', 1, 1),
    (10, 11, 10, 'Making excessive noise', '2024-02-06 09:15:00', 2, 1),
    (11, 12, 11, 'Keeping a pet in the room', '2024-02-08 14:30:00', 3, 1),
    (12, 13, 12, 'Having unauthorized visitors after hours', '2024-02-10 17:00:00', 4, 1),
    (13, 14, 13, 'Smoking in the room', '2024-02-14 11:20:00', 1, 1);
-- Generating data for guideline table
INSERT INTO guideline (guideName, img)
VALUES
    ('Fire Safety Guidelines', './Image/guideline/guideline1.jpg'),
    ('Room Cleaning Guidelines', './Image/guideline/guideline2.jpg'),
    ('Noise Reduction Guidelines', './Image/guideline/guideline3.jpg');

-- Generating data for bill table
INSERT INTO bill (roomID, [service], electric, water, roomFee, other, penMoney, createAt, deadline, payAt)
VALUES
    (1, 250000.00, 840000.00 , 82500.00, 3500000.00, 0.00, 0.00, '2022-01-30 00:00:00', '2022-02-15 00:00:00', '2022-02-10 12:00:00'),
    (2, 250000.00, 848000.00, 61000.00, 3000000.00, 0.00, 0.00, '2022-05-30 00:00:00', '2022-06-15 00:00:00', '2022-06-14 12:00:00'),
    (3, 250000.00, 912000.00, 91050.00, 2500000.00, 0.00, 0.00, '2022-09-30 00:00:00', '2022-10-15 00:00:00', '2022-10-14 12:00:00'),
    (4, 250000.00, 840000.00 , 82500.00, 3500000.00, 0.00, 0.00, '2023-01-30 00:00:00', '2023-02-15 00:00:00', '2023-02-13 12:00:00'),
    (5, 355000.00, 840000.00 , 82500.00, 3000000.00, 0.00, 0.00, '2023-05-30 00:00:00', '2023-06-15 00:00:00', '2023-06-12 12:00:00'),
    (6, 450000.00, 840000.00 , 82500.00, 3000000.00, 0.00, 0.00, '2023-09-30 00:00:00', '2023-10-15 00:00:00', '2023-10-13 12:00:00'),
    (7, 250000.00, 840000.00 , 82500.00, 2500000.00, 0.00, 0.00, '2024-01-30 00:00:00', '2024-02-15 00:00:00', NULL);
    
-- Generating data for usage table
INSERT INTO usage (roomID, electricNum, waterBlock, createAt, payAt)
VALUES
(1, 210.00, 16.5, '2022-02-15 00:00:00', '2022-02-10 12:00:00'),
(2, 212.00, 12.2, '2022-06-15 00:00:00', '2022-06-14 12:00:00'),
(3, 228.00, 18.21, '2022-10-15 00:00:00', '2022-10-14 12:00:00'),
(4, 210.00, 16.5, '2024-02-15 00:00:00', '2023-02-13 12:00:00'),
(5, 210.00, 16.5, '2024-06-15 00:00:00', '2023-06-12 12:00:00'),
(6, 210.00, 16.5, '2024-10-15 00:00:00', '2023-10-13 12:00:00'),
(7, 210.00, 16.5, '2024-02-15 00:00:00', NULL);
