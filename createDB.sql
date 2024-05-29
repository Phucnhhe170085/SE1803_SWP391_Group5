CREATE DATABASE HL_Motel;
GO

USE HL_Motel;
GO

CREATE TABLE room (
    roomID INT IDENTITY(1,1) PRIMARY KEY,
    roomFloor INT NOT NULL,
    roomNumber INT NOT NULL,
    roomSize INT NOT NULL,
	roomFee MONEY NOT NULL,
    roomImg NVARCHAR(MAX) NOT NULL
);

CREATE TABLE item (
    itemID INT IDENTITY(1,1) PRIMARY KEY,
    itemName NVARCHAR(MAX) NOT NULL,
    itemImg NVARCHAR(MAX) NOT NULL
);

CREATE TABLE roomItem (
    roomItemID INT IDENTITY(1,1) PRIMARY KEY,
    roomID INT NOT NULL,
    itemID INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (roomID) REFERENCES room(roomID),
    FOREIGN KEY (itemID) REFERENCES item(itemID)
);

CREATE TABLE account (
    userID INT IDENTITY(1,1) PRIMARY KEY,
    userMail NVARCHAR(MAX) NOT NULL,
    userPassword NVARCHAR(MAX) NOT NULL,
    userRole INT NOT NULL
);

CREATE TABLE [user] (
    userID INT PRIMARY KEY,
    userName NVARCHAR(MAX) NOT NULL,
    userGender NVARCHAR(10) NOT NULL,
    userBirth DATE NOT NULL,
    userAddress NVARCHAR(MAX) NOT NULL,
    userPhone NVARCHAR(20) NOT NULL,
    userAvatar NVARCHAR(MAX) NOT NULL,
    FOREIGN KEY (userID) REFERENCES account(userID)
);


CREATE TABLE renter (
    renterID INT IDENTITY(1,1) PRIMARY KEY,
    userID INT NOT NULL,
    roomID INT NULL,
    renterStatus BIT NOT NULL,
    renterHaveRoom BIT NOT NULL,
    CGRScore int NOT NULL,
    balance MONEY NOT NULL,
    FOREIGN KEY (userID) REFERENCES [user](userID),
    FOREIGN KEY (roomID) REFERENCES room(roomID)
);

CREATE TABLE [security] (
    seID INT IDENTITY(1,1) PRIMARY KEY,
    userID INT NOT NULL,
    sShift BIT NOT NULL,
	seStatus BIT NOT NULL,
    FOREIGN KEY (userID) REFERENCES [user](userID)
);

CREATE TABLE [rule] (
    ruleID INT IDENTITY(1,1) PRIMARY KEY,
    ruleName NVARCHAR(MAX) NOT NULL,
    img NVARCHAR(MAX) NOT NULL,
	scoreChange INT NOT NULL,
    penMoney MONEY NOT NULL
);

CREATE TABLE penalty (
    penID INT IDENTITY(1,1) PRIMARY KEY,
    reportID INT NOT NULL,
    accuseID INT NOT NULL,
    roomID INT NOT NULL,
    [description] NVARCHAR(MAX) NOT NULL,
    penDate DATETIME NOT NULL,
    ruleID INT NOT NULL,
    penStatus BIT NOT NULL,
    FOREIGN KEY (reportID) REFERENCES renter(renterID),
    FOREIGN KEY (accuseID) REFERENCES renter(renterID),
    FOREIGN KEY (roomID) REFERENCES room(roomID),
    FOREIGN KEY (ruleID) REFERENCES [rule](ruleID)
);

CREATE TABLE guideline (
    guideID INT IDENTITY(1,1) PRIMARY KEY,
    guideName NVARCHAR(MAX) NOT NULL,
    img NVARCHAR(MAX) NOT NULL
);

CREATE TABLE news (
    newID INT IDENTITY(1,1) PRIMARY KEY,
    newTitle NVARCHAR(MAX) NOT NULL,
    description NVARCHAR(MAX) NOT NULL,
    img NVARCHAR(MAX) NULL,
    creatAt DATETIME NOT NULL,
);

CREATE TABLE bill (
    billID INT IDENTITY(1,1) PRIMARY KEY,
    roomID INT NOT NULL,
    [service] MONEY NOT NULL,
    electric MONEY NOT NULL,
    water MONEY NOT NULL,
    roomFee MONEY NOT NULL,
    other MONEY NOT NULL,
    penMoney MONEY NOT NULL,
    createAt DATETIME NOT NULL,
    deadline DATETIME NOT NULL,
    payAt DATETIME NULL,
    FOREIGN KEY (roomID) REFERENCES room(roomID)
);

CREATE TABLE usage (
    usageID INT IDENTITY(1,1) PRIMARY KEY,
    roomID INT NOT NULL,
    electricNum FLOAT NOT NULL,
    waterBlock FLOAT NOT NULL,
    createAt DATETIME NOT NULL,
    payAt DATETIME NULL,
    FOREIGN KEY (roomID) REFERENCES room(roomID)
);

CREATE TABLE request (
    requestID INT IDENTITY(1,1) PRIMARY KEY,
    renterID INT NOT NULL,
    requestType INT NOT NULL,
    title NVARCHAR(MAX) NOT NULL,
    [description] NVARCHAR(MAX) NOT NULL,
    createAt DATETIME NOT NULL,
    resStatus NVARCHAR(MAX) NOT NULL,
    FOREIGN KEY (renterID) REFERENCES renter(renterID)
);
