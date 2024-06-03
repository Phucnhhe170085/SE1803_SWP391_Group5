USE [master]
GO
/****** Object:  Database [HL_Motel]    Script Date: 5/19/2024 9:05:57 PM ******/
CREATE DATABASE [HL_Motel]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HL_Motel', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\HL_Motel.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HL_Motel_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\HL_Motel_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [HL_Motel] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HL_Motel].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HL_Motel] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HL_Motel] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HL_Motel] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HL_Motel] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HL_Motel] SET ARITHABORT OFF 
GO
ALTER DATABASE [HL_Motel] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HL_Motel] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HL_Motel] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HL_Motel] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HL_Motel] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HL_Motel] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HL_Motel] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HL_Motel] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HL_Motel] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HL_Motel] SET  ENABLE_BROKER 
GO
ALTER DATABASE [HL_Motel] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HL_Motel] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HL_Motel] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HL_Motel] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HL_Motel] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HL_Motel] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HL_Motel] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HL_Motel] SET RECOVERY FULL 
GO
ALTER DATABASE [HL_Motel] SET  MULTI_USER 
GO
ALTER DATABASE [HL_Motel] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HL_Motel] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HL_Motel] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HL_Motel] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [HL_Motel] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [HL_Motel] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'HL_Motel', N'ON'
GO
ALTER DATABASE [HL_Motel] SET QUERY_STORE = ON
GO
ALTER DATABASE [HL_Motel] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [HL_Motel]
GO
/****** Object:  User [tester]    Script Date: 5/19/2024 9:05:58 PM ******/
CREATE USER [tester] FOR LOGIN [sa] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[account]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[userID] [int] IDENTITY(1,1) NOT NULL,
	[userMail] [nvarchar](max) NOT NULL,
	[userPassword] [nvarchar](max) NOT NULL,
	[userRole] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bill]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bill](
	[billID] [int] IDENTITY(1,1) NOT NULL,
	[roomID] [int] NOT NULL,
	[service] [money] NOT NULL,
	[electric] [money] NOT NULL,
	[water] [money] NOT NULL,
	[roomFee] [money] NOT NULL,
	[other] [money] NOT NULL,
	[penMoney] [money] NOT NULL,
	[createAt] [datetime] NOT NULL,
	[deadline] [datetime] NOT NULL,
	[payAt] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[billID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[guideline]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[guideline](
	[guideID] [int] IDENTITY(1,1) NOT NULL,
	[guideName] [nvarchar](max) NOT NULL,
	[img] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[guideID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[item]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[item](
	[itemID] [int] IDENTITY(1,1) NOT NULL,
	[itemName] [nvarchar](max) NOT NULL,
	[itemImg] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[itemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[news]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news](
	[newID] [int] IDENTITY(1,1) NOT NULL,
	[newTitle] [nvarchar](max) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[newID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[penalty]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[penalty](
	[penID] [int] IDENTITY(1,1) NOT NULL,
	[reportID] [int] NOT NULL,
	[accuseID] [int] NOT NULL,
	[roomID] [int] NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[penDate] [datetime] NOT NULL,
	[ruleID] [int] NOT NULL,
	[penStatus] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[penID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[renter]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[renter](
	[renterID] [int] IDENTITY(1,1) NOT NULL,
	[userID] [int] NOT NULL,
	[roomID] [int] NULL,
	[renterStatus] [bit] NOT NULL,
	[renterHaveRoom] [bit] NOT NULL,
	[CGRScore] [int] NOT NULL,
	[balance] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[renterID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[request]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[request](
	[requestID] [int] IDENTITY(1,1) NOT NULL,
	[renterID] [int] NOT NULL,
	[requestType] [int] NOT NULL,
	[title] [nvarchar](max) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[createAt] [datetime] NOT NULL,
	[resStatus] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[requestID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[room]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room](
	[roomID] [int] IDENTITY(1,1) NOT NULL,
	[roomFloor] [int] NOT NULL,
	[roomNumber] [int] NOT NULL,
	[roomSize] [int] NOT NULL,
	[roomImg] [nvarchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[roomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roomItem]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roomItem](
	[roomItemID] [int] IDENTITY(1,1) NOT NULL,
	[roomID] [int] NOT NULL,
	[itemID] [int] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[roomItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[rule]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rule](
	[ruleID] [int] IDENTITY(1,1) NOT NULL,
	[ruleName] [nvarchar](max) NOT NULL,
	[img] [nvarchar](max) NOT NULL,
	[scoreChange] [int] NOT NULL,
	[penMoney] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ruleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[security]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[security](
	[seID] [int] IDENTITY(1,1) NOT NULL,
	[userID] [int] NOT NULL,
	[sShift] [bit] NOT NULL,
	[seStatus] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[seID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usage]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usage](
	[usageID] [int] IDENTITY(1,1) NOT NULL,
	[roomID] [int] NOT NULL,
	[electricNum] [float] NOT NULL,
	[waterBlock] [float] NOT NULL,
	[createAt] [datetime] NOT NULL,
	[payAt] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[usageID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 5/19/2024 9:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[userID] [int] NOT NULL,
	[userName] [nvarchar](max) NOT NULL,
	[userGender] [nvarchar](10) NOT NULL,
	[userBirth] [date] NOT NULL,
	[userAddress] [nvarchar](max) NOT NULL,
	[userPhone] [nvarchar](20) NOT NULL,
	[userAvatar] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK__user__CB9A1CDFD42B3CE8] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[account] ON 

INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (1, N'tester', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (2, N'nguyenhuong@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (3, N'phamvannam@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (4, N'tranlananh@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (5, N'levanduy@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (6, N'nguyenthimai@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (7, N'hoangvanlong@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (8, N'dothihang@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (9, N'vuvantuan@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (10, N'nguyenvananh@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (11, N'phanvanhung@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (12, N'buithihang@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (13, N'travanhung@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (14, N'dangthiha@gmail.com', N'1', 1)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (15, N'nguyenvanlinh@gmail.com', N'1', 2)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (16, N'nguyenthihong@gmail.com', N'1', 2)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (17, N'levanquan@gmail.com', N'1', 2)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (18, N'tranthithu@gmail.com', N'1', 2)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (19, N'phamvankhoi@gmail.com', N'1', 3)
INSERT [dbo].[account] ([userID], [userMail], [userPassword], [userRole]) VALUES (20, N'admin@gmail.com', N'1', 4)
SET IDENTITY_INSERT [dbo].[account] OFF
GO
SET IDENTITY_INSERT [dbo].[bill] ON 

INSERT [dbo].[bill] ([billID], [roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt]) VALUES (1, 1, 250000.0000, 840000.0000, 82500.0000, 3500000.0000, 0.0000, 0.0000, CAST(N'2022-01-30T00:00:00.000' AS DateTime), CAST(N'2022-02-15T00:00:00.000' AS DateTime), CAST(N'2022-02-10T12:00:00.000' AS DateTime))
INSERT [dbo].[bill] ([billID], [roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt]) VALUES (2, 2, 250000.0000, 848000.0000, 61000.0000, 3000000.0000, 0.0000, 0.0000, CAST(N'2022-05-30T00:00:00.000' AS DateTime), CAST(N'2022-06-15T00:00:00.000' AS DateTime), CAST(N'2022-06-14T12:00:00.000' AS DateTime))
INSERT [dbo].[bill] ([billID], [roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt]) VALUES (3, 3, 250000.0000, 912000.0000, 91050.0000, 2500000.0000, 0.0000, 0.0000, CAST(N'2022-09-30T00:00:00.000' AS DateTime), CAST(N'2022-10-15T00:00:00.000' AS DateTime), CAST(N'2022-10-14T12:00:00.000' AS DateTime))
INSERT [dbo].[bill] ([billID], [roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt]) VALUES (4, 4, 250000.0000, 840000.0000, 82500.0000, 3500000.0000, 0.0000, 0.0000, CAST(N'2023-01-30T00:00:00.000' AS DateTime), CAST(N'2023-02-15T00:00:00.000' AS DateTime), CAST(N'2023-02-13T12:00:00.000' AS DateTime))
INSERT [dbo].[bill] ([billID], [roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt]) VALUES (5, 5, 355000.0000, 840000.0000, 82500.0000, 3000000.0000, 0.0000, 0.0000, CAST(N'2023-05-30T00:00:00.000' AS DateTime), CAST(N'2023-06-15T00:00:00.000' AS DateTime), CAST(N'2023-06-12T12:00:00.000' AS DateTime))
INSERT [dbo].[bill] ([billID], [roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt]) VALUES (6, 6, 450000.0000, 840000.0000, 82500.0000, 3000000.0000, 0.0000, 0.0000, CAST(N'2023-09-30T00:00:00.000' AS DateTime), CAST(N'2023-10-15T00:00:00.000' AS DateTime), CAST(N'2023-10-13T12:00:00.000' AS DateTime))
INSERT [dbo].[bill] ([billID], [roomID], [service], [electric], [water], [roomFee], [other], [penMoney], [createAt], [deadline], [payAt]) VALUES (7, 7, 250000.0000, 840000.0000, 82500.0000, 2500000.0000, 0.0000, 0.0000, CAST(N'2024-01-30T00:00:00.000' AS DateTime), CAST(N'2024-02-15T00:00:00.000' AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[bill] OFF
GO
SET IDENTITY_INSERT [dbo].[guideline] ON 

INSERT [dbo].[guideline] ([guideID], [guideName], [img]) VALUES (1, N'Fire Safety Guidelines', N'./Image/guideline/guideline1.jpg')
INSERT [dbo].[guideline] ([guideID], [guideName], [img]) VALUES (2, N'Room Cleaning Guidelines', N'./Image/guideline/guideline2.jpg')
INSERT [dbo].[guideline] ([guideID], [guideName], [img]) VALUES (3, N'Noise Reduction Guidelines', N'./Image/guideline/guideline3.jpg')
SET IDENTITY_INSERT [dbo].[guideline] OFF
GO
SET IDENTITY_INSERT [dbo].[item] ON 

INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (1, N'Chair', N'./Image/item/chair.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (2, N'Table', N'./Image/item/table.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (3, N'Single Bed', N'./Image/item/single_bed.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (4, N'Fan', N'./Image/item/fan.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (5, N'Desk Lamp', N'./Image/item/desk_lamp.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (6, N'Bookshelf', N'./Image/item/bookshelf.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (7, N'Wardrobe', N'./Image/item/wardrobe.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (8, N'Curtains', N'./Image/item/curtains.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (9, N'TV', N'./Image/item/tv.jpg')
INSERT [dbo].[item] ([itemID], [itemName], [itemImg]) VALUES (10, N'Sofa', N'./Image/item/sofa.jpg')
SET IDENTITY_INSERT [dbo].[item] OFF
GO
SET IDENTITY_INSERT [dbo].[news] ON 

INSERT [dbo].[news] ([newID], [newTitle], [description]) VALUES (1, N'New Community Events', N'Join us for our upcoming community events happening this month!')
INSERT [dbo].[news] ([newID], [newTitle], [description]) VALUES (2, N'Maintenance Notice', N'Scheduled maintenance will take place on February 28th, please be advised.')
INSERT [dbo].[news] ([newID], [newTitle], [description]) VALUES (3, N'Community Updates', N'Stay tuned for the latest updates and announcements from our community.')
SET IDENTITY_INSERT [dbo].[news] OFF
GO
SET IDENTITY_INSERT [dbo].[penalty] ON 

INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (1, 1, 2, 1, N'Smoking in the room', CAST(N'2022-01-15T10:30:00.000' AS DateTime), 1, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (2, 2, 3, 2, N'Making excessive noise', CAST(N'2022-01-17T09:45:00.000' AS DateTime), 2, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (3, 3, 4, 3, N'Keeping a pet in the room', CAST(N'2022-01-19T14:20:00.000' AS DateTime), 3, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (4, 4, 5, 4, N'Having unauthorized visitors after hours', CAST(N'2022-01-21T16:00:00.000' AS DateTime), 4, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (5, 5, 6, 5, N'Smoking in the room', CAST(N'2022-01-25T11:10:00.000' AS DateTime), 1, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (6, 6, 7, 6, N'Making excessive noise', CAST(N'2023-01-27T08:30:00.000' AS DateTime), 2, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (7, 7, 8, 7, N'Keeping a pet in the room', CAST(N'2023-01-29T13:45:00.000' AS DateTime), 3, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (8, 8, 9, 8, N'Having unauthorized visitors after hours', CAST(N'2023-01-31T15:20:00.000' AS DateTime), 4, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (9, 9, 10, 9, N'Smoking in the room', CAST(N'2023-02-04T10:00:00.000' AS DateTime), 1, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (10, 10, 11, 10, N'Making excessive noise', CAST(N'2024-02-06T09:15:00.000' AS DateTime), 2, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (11, 11, 12, 11, N'Keeping a pet in the room', CAST(N'2024-02-08T14:30:00.000' AS DateTime), 3, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (12, 12, 13, 12, N'Having unauthorized visitors after hours', CAST(N'2024-02-10T17:00:00.000' AS DateTime), 4, 1)
INSERT [dbo].[penalty] ([penID], [reportID], [accuseID], [roomID], [description], [penDate], [ruleID], [penStatus]) VALUES (13, 13, 14, 13, N'Smoking in the room', CAST(N'2024-02-14T11:20:00.000' AS DateTime), 1, 1)
SET IDENTITY_INSERT [dbo].[penalty] OFF
GO
SET IDENTITY_INSERT [dbo].[renter] ON 

INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (1, 1, 1, 1, 1, 100, 1500.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (2, 2, 2, 1, 1, 100, 1800.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (3, 3, 3, 1, 1, 100, 2000.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (4, 4, 4, 1, 1, 100, 2200.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (5, 5, 5, 1, 1, 100, 2400.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (6, 6, 6, 1, 1, 100, 1500.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (7, 7, 7, 1, 1, 100, 1800.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (8, 8, 8, 1, 1, 100, 2000.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (9, 9, 9, 1, 1, 100, 2200.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (10, 10, 10, 1, 1, 100, 2400.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (11, 11, 11, 1, 1, 100, 1500.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (12, 12, 12, 1, 1, 100, 1800.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (13, 13, 13, 1, 1, 100, 2000.0000)
INSERT [dbo].[renter] ([renterID], [userID], [roomID], [renterStatus], [renterHaveRoom], [CGRScore], [balance]) VALUES (14, 14, 14, 1, 1, 100, 2200.0000)
SET IDENTITY_INSERT [dbo].[renter] OFF
GO
SET IDENTITY_INSERT [dbo].[room] ON 

INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (1, 1, 101, 1, N'./Image/room/room1.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (2, 1, 102, 2, N'./Image/room/room2.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (3, 1, 103, 3, N'./Image/room/room3.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (4, 1, 104, 1, N'./Image/room/room4.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (5, 1, 105, 2, N'./Image/room/room5.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (6, 2, 201, 2, N'./Image/room/room6.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (7, 2, 202, 3, N'./Image/room/room7.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (8, 2, 203, 1, N'./Image/room/room8.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (9, 2, 204, 1, N'./Image/room/room9.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (10, 2, 205, 2, N'./Image/room/room10.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (11, 3, 301, 3, N'./Image/room/room11.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (12, 3, 302, 1, N'./Image/room/room12.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (13, 3, 303, 2, N'./Image/room/room13.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (14, 3, 304, 2, N'./Image/room/room14.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (15, 3, 305, 3, N'./Image/room/room15.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (16, 4, 401, 1, N'./Image/room/room16.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (17, 4, 402, 3, N'./Image/room/room17.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (18, 4, 403, 1, N'./Image/room/room18.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (19, 4, 404, 2, N'./Image/room/room19.jpg')
INSERT [dbo].[room] ([roomID], [roomFloor], [roomNumber], [roomSize], [roomImg]) VALUES (20, 4, 405, 3, N'./Image/room/room20.jpg')
SET IDENTITY_INSERT [dbo].[room] OFF
GO
SET IDENTITY_INSERT [dbo].[roomItem] ON 

INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (1, 1, 1, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (2, 1, 2, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (3, 1, 3, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (4, 1, 4, 4)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (5, 1, 5, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (6, 2, 1, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (7, 2, 3, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (8, 2, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (9, 2, 6, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (10, 2, 8, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (11, 3, 2, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (12, 3, 4, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (13, 3, 6, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (14, 3, 7, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (15, 3, 9, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (16, 4, 3, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (17, 4, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (18, 4, 7, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (19, 4, 8, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (20, 4, 10, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (21, 5, 1, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (22, 5, 2, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (23, 5, 3, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (24, 5, 4, 4)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (25, 5, 5, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (26, 6, 1, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (27, 6, 2, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (28, 6, 3, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (29, 6, 4, 4)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (30, 6, 5, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (31, 7, 1, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (32, 7, 3, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (33, 7, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (34, 7, 6, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (35, 7, 8, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (36, 8, 2, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (37, 8, 4, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (38, 8, 6, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (39, 8, 7, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (40, 8, 9, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (41, 9, 3, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (42, 9, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (43, 9, 7, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (44, 9, 8, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (45, 9, 10, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (46, 10, 1, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (47, 10, 2, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (48, 10, 3, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (49, 10, 4, 4)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (50, 10, 5, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (51, 11, 1, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (52, 11, 3, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (53, 11, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (54, 11, 6, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (55, 11, 8, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (56, 12, 2, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (57, 12, 4, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (58, 12, 6, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (59, 12, 7, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (60, 12, 9, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (61, 13, 3, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (62, 13, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (63, 13, 7, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (64, 13, 8, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (65, 13, 10, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (66, 14, 1, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (67, 14, 2, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (68, 14, 3, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (69, 14, 4, 4)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (70, 14, 5, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (71, 15, 1, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (72, 15, 3, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (73, 15, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (74, 15, 6, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (75, 15, 8, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (76, 16, 2, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (77, 16, 4, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (78, 16, 6, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (79, 16, 7, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (80, 16, 9, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (81, 17, 3, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (82, 17, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (83, 17, 7, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (84, 17, 8, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (85, 17, 10, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (86, 18, 1, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (87, 18, 2, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (88, 18, 3, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (89, 18, 4, 4)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (90, 18, 5, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (91, 19, 1, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (92, 19, 3, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (93, 19, 5, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (94, 19, 6, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (95, 19, 8, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (96, 20, 2, 3)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (97, 20, 4, 2)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (98, 20, 6, 1)
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (99, 20, 7, 3)
GO
INSERT [dbo].[roomItem] ([roomItemID], [roomID], [itemID], [quantity]) VALUES (100, 20, 9, 2)
SET IDENTITY_INSERT [dbo].[roomItem] OFF
GO
SET IDENTITY_INSERT [dbo].[rule] ON 

INSERT [dbo].[rule] ([ruleID], [ruleName], [img], [scoreChange], [penMoney]) VALUES (1, N'No Smoking', N'./Image/rule/rule1.jpg', -10, 100.0000)
INSERT [dbo].[rule] ([ruleID], [ruleName], [img], [scoreChange], [penMoney]) VALUES (2, N'Quiet Hours', N'./Image/rule//rule2.jpg', -5, 50.0000)
INSERT [dbo].[rule] ([ruleID], [ruleName], [img], [scoreChange], [penMoney]) VALUES (3, N'No Pets Allowed', N'./Image/rule//rule3.jpg', -15, 150.0000)
INSERT [dbo].[rule] ([ruleID], [ruleName], [img], [scoreChange], [penMoney]) VALUES (4, N'Visitor Restrictions', N'./Image/rule//rule4.jpg', -10, 80.0000)
SET IDENTITY_INSERT [dbo].[rule] OFF
GO
SET IDENTITY_INSERT [dbo].[security] ON 

INSERT [dbo].[security] ([seID], [userID], [sShift], [seStatus]) VALUES (1, 15, 1, 1)
INSERT [dbo].[security] ([seID], [userID], [sShift], [seStatus]) VALUES (2, 16, 1, 1)
INSERT [dbo].[security] ([seID], [userID], [sShift], [seStatus]) VALUES (3, 17, 0, 1)
INSERT [dbo].[security] ([seID], [userID], [sShift], [seStatus]) VALUES (4, 18, 0, 1)
SET IDENTITY_INSERT [dbo].[security] OFF
GO
SET IDENTITY_INSERT [dbo].[usage] ON 

INSERT [dbo].[usage] ([usageID], [roomID], [electricNum], [waterBlock], [createAt], [payAt]) VALUES (1, 1, 210, 16.5, CAST(N'2022-02-15T00:00:00.000' AS DateTime), CAST(N'2022-02-10T12:00:00.000' AS DateTime))
INSERT [dbo].[usage] ([usageID], [roomID], [electricNum], [waterBlock], [createAt], [payAt]) VALUES (2, 2, 212, 12.2, CAST(N'2022-06-15T00:00:00.000' AS DateTime), CAST(N'2022-06-14T12:00:00.000' AS DateTime))
INSERT [dbo].[usage] ([usageID], [roomID], [electricNum], [waterBlock], [createAt], [payAt]) VALUES (3, 3, 228, 18.21, CAST(N'2022-10-15T00:00:00.000' AS DateTime), CAST(N'2022-10-14T12:00:00.000' AS DateTime))
INSERT [dbo].[usage] ([usageID], [roomID], [electricNum], [waterBlock], [createAt], [payAt]) VALUES (4, 4, 210, 16.5, CAST(N'2024-02-15T00:00:00.000' AS DateTime), CAST(N'2023-02-13T12:00:00.000' AS DateTime))
INSERT [dbo].[usage] ([usageID], [roomID], [electricNum], [waterBlock], [createAt], [payAt]) VALUES (5, 5, 210, 16.5, CAST(N'2024-06-15T00:00:00.000' AS DateTime), CAST(N'2023-06-12T12:00:00.000' AS DateTime))
INSERT [dbo].[usage] ([usageID], [roomID], [electricNum], [waterBlock], [createAt], [payAt]) VALUES (6, 6, 210, 16.5, CAST(N'2024-10-15T00:00:00.000' AS DateTime), CAST(N'2023-10-13T12:00:00.000' AS DateTime))
INSERT [dbo].[usage] ([usageID], [roomID], [electricNum], [waterBlock], [createAt], [payAt]) VALUES (7, 7, 210, 16.5, CAST(N'2024-02-15T00:00:00.000' AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[usage] OFF
GO
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (1, N'Nguyen Hong Phuc', N'Male', CAST(N'2003-12-02' AS Date), N'Phuc@gmail.com', N'0987654321', N'./Image/user/avatar1.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (2, N'Vu Duy Hung', N'Female', CAST(N'2002-10-20' AS Date), N'56 Lê Lợi, Quận 1, Thành phố Hồ Chí Minh', N'0981234567', N'./Image/user/avatar2.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (3, N'Phạm Quang Thắng', N'Male', CAST(N'2002-03-02' AS Date), N'39 Lê Hồng Phong, TP. Hải Phòng', N'0976543210', N'./Image/user/avatar3.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (4, N'Trần Thị Lan Anh', N'Female', CAST(N'2003-12-10' AS Date), N'105 Trần Phú, TP. Vinh, Nghệ An', N'0965432109', N'./Image/user/avatar4.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (5, N'Lê Văn Duy', N'Male', CAST(N'2003-08-25' AS Date), N'30 Đại Cồ Việt, Hai Bà Trưng, Hà Nội', N'0932109876', N'./Image/user/avatar5.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (6, N'Nguyễn Thị Mai', N'Female', CAST(N'2003-06-18' AS Date), N'15 Hoàng Cầu, Đống Đa, Hà Nội', N'0943210987', N'./Image/user/avatar6.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (7, N'Hoàng Văn Long', N'Male', CAST(N'2003-02-28' AS Date), N'70 Lê Duẩn, Hoàn Kiếm, Hà Nội', N'0910987654', N'./Image/user/avatar7.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (8, N'Đỗ Thị Hằng', N'Female', CAST(N'2004-09-07' AS Date), N'45 Lý Thường Kiệt, Hà Tĩnh', N'0921098765', N'./Image/user/avatar8.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (9, N'Vũ Văn Tuấn', N'Male', CAST(N'2005-11-12' AS Date), N'112 Lý Thường Kiệt, Hà Tĩnh', N'0909876543', N'./Image/user/avatar9.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (10, N'Nguyễn Vân Anh', N'Other', CAST(N'2005-07-22' AS Date), N'5 Hàng Bài, Hoàn Kiếm, Hà Nội', N'0998765432', N'./Image/user/avatar10.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (11, N'Phan Văn Hùng', N'Male', CAST(N'2005-04-03' AS Date), N'51 Nguyễn Thái Học, Cà Mau', N'0954321098', N'./Image/user/avatar11.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (12, N'Bùi Thị Hằng', N'Female', CAST(N'2005-01-30' AS Date), N'36 Trần Nhân Tông, Hải Dương', N'0912345678', N'./Image/user/avatar12.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (13, N'Trần Văn Hùng', N'Male', CAST(N'2000-08-14' AS Date), N'35 Lê Thánh Tông, Hoàn Kiếm, Hà Nội', N'0987654321', N'./Image/user/avatar13.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (14, N'Đặng Thị Hà', N'Other', CAST(N'2000-03-17' AS Date), N'80 Lê Lai, TP. Biên Hòa, Đồng Nai', N'0987654321', N'./Image/user/avatar14.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (15, N'Nguyễn Văn Linh', N'Male', CAST(N'1991-12-05' AS Date), N'100 Hai Bà Trưng, Hoàn Kiếm, Hà Nội', N'0987654321', N'./Image/user/avatar15.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (16, N'Nguyễn Hoàng Hồng', N'Male', CAST(N'1987-05-25' AS Date), N'92 Điện Biên Phủ, Lào Cai', N'0987654321', N'./Image/user/avatar16.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (17, N'Lê Văn Quân', N'Male', CAST(N'1985-09-12' AS Date), N'18 Trần Phú, Ba Đình, Hà Nội', N'0987654321', N'./Image/user/avatar17.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (18, N'Trần Thị Thu', N'Female', CAST(N'1996-11-30' AS Date), N'42 Trần Phú, Nam Định', N'0987654321', N'./Image/user/avatar18.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (19, N'Phạm Văn Khôi', N'Male', CAST(N'1986-02-08' AS Date), N'20 Lý Thường Kiệt, Hoàn Kiếm, Hà Nội', N'0987654321', N'./Image/user/avatar19.jpg')
INSERT [dbo].[user] ([userID], [userName], [userGender], [userBirth], [userAddress], [userPhone], [userAvatar]) VALUES (20, N'Admin', N'Unknown', CAST(N'1989-07-18' AS Date), N'Unknown', N'0987654321', N'./Image/user/avatar20.jpg')
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [FK__account__userID__412EB0B6] FOREIGN KEY([userID])
REFERENCES [dbo].[user] ([userID])
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [FK__account__userID__412EB0B6]
GO
ALTER TABLE [dbo].[bill]  WITH CHECK ADD FOREIGN KEY([roomID])
REFERENCES [dbo].[room] ([roomID])
GO
ALTER TABLE [dbo].[penalty]  WITH CHECK ADD FOREIGN KEY([accuseID])
REFERENCES [dbo].[renter] ([renterID])
GO
ALTER TABLE [dbo].[penalty]  WITH CHECK ADD FOREIGN KEY([reportID])
REFERENCES [dbo].[renter] ([renterID])
GO
ALTER TABLE [dbo].[penalty]  WITH CHECK ADD FOREIGN KEY([roomID])
REFERENCES [dbo].[room] ([roomID])
GO
ALTER TABLE [dbo].[penalty]  WITH CHECK ADD FOREIGN KEY([ruleID])
REFERENCES [dbo].[rule] ([ruleID])
GO
ALTER TABLE [dbo].[renter]  WITH CHECK ADD FOREIGN KEY([roomID])
REFERENCES [dbo].[room] ([roomID])
GO
ALTER TABLE [dbo].[renter]  WITH CHECK ADD  CONSTRAINT [FK__renter__userID__440B1D61] FOREIGN KEY([userID])
REFERENCES [dbo].[user] ([userID])
GO
ALTER TABLE [dbo].[renter] CHECK CONSTRAINT [FK__renter__userID__440B1D61]
GO
ALTER TABLE [dbo].[request]  WITH CHECK ADD FOREIGN KEY([renterID])
REFERENCES [dbo].[renter] ([renterID])
GO
ALTER TABLE [dbo].[roomItem]  WITH CHECK ADD FOREIGN KEY([itemID])
REFERENCES [dbo].[item] ([itemID])
GO
ALTER TABLE [dbo].[roomItem]  WITH CHECK ADD FOREIGN KEY([roomID])
REFERENCES [dbo].[room] ([roomID])
GO
ALTER TABLE [dbo].[security]  WITH CHECK ADD  CONSTRAINT [FK__security__userID__47DBAE45] FOREIGN KEY([userID])
REFERENCES [dbo].[user] ([userID])
GO
ALTER TABLE [dbo].[security] CHECK CONSTRAINT [FK__security__userID__47DBAE45]
GO
ALTER TABLE [dbo].[usage]  WITH CHECK ADD FOREIGN KEY([roomID])
REFERENCES [dbo].[room] ([roomID])
GO
USE [master]
GO
ALTER DATABASE [HL_Motel] SET  READ_WRITE 
GO
