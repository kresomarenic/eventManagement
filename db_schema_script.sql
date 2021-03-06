USE [master]
GO
/****** Object:  Database [EventManagement]    Script Date: 23.4.2019. 9:38:41 ******/
CREATE DATABASE [EventManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'EventManagent', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.LOCALHOST\MSSQL\DATA\EventManagent.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'EventManagent_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.LOCALHOST\MSSQL\DATA\EventManagent_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [EventManagement] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EventManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EventManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EventManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EventManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EventManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EventManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [EventManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [EventManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EventManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EventManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EventManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EventManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EventManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EventManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EventManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EventManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [EventManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EventManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EventManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EventManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EventManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EventManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EventManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EventManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [EventManagement] SET  MULTI_USER 
GO
ALTER DATABASE [EventManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EventManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EventManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EventManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [EventManagement] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'EventManagement', N'ON'
GO
ALTER DATABASE [EventManagement] SET QUERY_STORE = OFF
GO
USE [EventManagement]
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [EventManagement]
GO
/****** Object:  User [tst_postPoduzetnik]    Script Date: 23.4.2019. 9:38:41 ******/
CREATE USER [tst_postPoduzetnik] FOR LOGIN [tst_postPoduzetnik] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [tst_postPoduzetnik]
GO
/****** Object:  Table [dbo].[city]    Script Date: 23.4.2019. 9:38:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[city](
	[c_id] [bigint] IDENTITY(1,1) NOT NULL,
	[c_code] [varchar](255) NULL,
	[c_name] [varchar](255) NULL,
	[c_size_id] [bigint] NULL,
	[c_ou_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[city_size]    Script Date: 23.4.2019. 9:38:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[city_size](
	[cs_id] [bigint] IDENTITY(1,1) NOT NULL,
	[cs_code] [varchar](255) NULL,
	[cs_active] [bit] NULL,
	[cs_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[cs_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[event]    Script Date: 23.4.2019. 9:38:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[event](
	[ev_id] [bigint] IDENTITY(1,1) NOT NULL,
	[ev_name] [varchar](255) NOT NULL,
	[ev_city_id] [bigint] NOT NULL,
	[ev_start] [datetime2](0) NOT NULL,
	[ev_end] [datetime2](0) NOT NULL,
	[ev_free_entry] [bit] NOT NULL,
 CONSTRAINT [PK__event__CCD8089F4415D55B] PRIMARY KEY CLUSTERED 
(
	[ev_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[org_unit]    Script Date: 23.4.2019. 9:38:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[org_unit](
	[ou_id] [bigint] IDENTITY(1,1) NOT NULL,
	[ou_descr] [varchar](255) NULL,
	[ou_name] [varchar](255) NULL,
	[ou_parent_id] [bigint] NULL,
	[ou_type_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[ou_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[org_unit_type]    Script Date: 23.4.2019. 9:38:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[org_unit_type](
	[out_id] [bigint] IDENTITY(1,1) NOT NULL,
	[out_code] [varchar](255) NULL,
	[out_active] [bit] NULL,
	[out_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[out_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[event] ADD  CONSTRAINT [DF_event_ev_free_entry]  DEFAULT ((0)) FOR [ev_free_entry]
GO
ALTER TABLE [dbo].[city]  WITH CHECK ADD  CONSTRAINT [FKa6393puloc0t1h1ic9rqcgsw8] FOREIGN KEY([c_ou_id])
REFERENCES [dbo].[org_unit] ([ou_id])
GO
ALTER TABLE [dbo].[city] CHECK CONSTRAINT [FKa6393puloc0t1h1ic9rqcgsw8]
GO
ALTER TABLE [dbo].[city]  WITH CHECK ADD  CONSTRAINT [FKhx7e64p11l6pit0vkuj8y1ao1] FOREIGN KEY([c_size_id])
REFERENCES [dbo].[city_size] ([cs_id])
GO
ALTER TABLE [dbo].[city] CHECK CONSTRAINT [FKhx7e64p11l6pit0vkuj8y1ao1]
GO
ALTER TABLE [dbo].[event]  WITH CHECK ADD  CONSTRAINT [FK2q8iarm4iuy6c9nr4hhylm326] FOREIGN KEY([ev_city_id])
REFERENCES [dbo].[city] ([c_id])
GO
ALTER TABLE [dbo].[event] CHECK CONSTRAINT [FK2q8iarm4iuy6c9nr4hhylm326]
GO
ALTER TABLE [dbo].[org_unit]  WITH CHECK ADD  CONSTRAINT [FKbtdrjj8e4jvuifu1haknem6b4] FOREIGN KEY([ou_type_id])
REFERENCES [dbo].[org_unit_type] ([out_id])
GO
ALTER TABLE [dbo].[org_unit] CHECK CONSTRAINT [FKbtdrjj8e4jvuifu1haknem6b4]
GO
ALTER TABLE [dbo].[org_unit]  WITH CHECK ADD  CONSTRAINT [FKgo24s6xocc68sjt0qoouoh5eh] FOREIGN KEY([ou_parent_id])
REFERENCES [dbo].[org_unit] ([ou_id])
GO
ALTER TABLE [dbo].[org_unit] CHECK CONSTRAINT [FKgo24s6xocc68sjt0qoouoh5eh]
GO
USE [master]
GO
ALTER DATABASE [EventManagement] SET  READ_WRITE 
GO
