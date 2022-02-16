USE [master]
GO

/****** Object:  Database [store]    Script Date: 16/2/2022 8:31:20 PM ******/
CREATE DATABASE [store]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'store', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.DUC\MSSQL\DATA\store.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'store_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.DUC\MSSQL\DATA\store_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [store].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [store] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [store] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [store] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [store] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [store] SET ARITHABORT OFF 
GO

ALTER DATABASE [store] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [store] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [store] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [store] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [store] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [store] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [store] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [store] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [store] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [store] SET  ENABLE_BROKER 
GO

ALTER DATABASE [store] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [store] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [store] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [store] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [store] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [store] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [store] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [store] SET RECOVERY FULL 
GO

ALTER DATABASE [store] SET  MULTI_USER 
GO

ALTER DATABASE [store] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [store] SET DB_CHAINING OFF 
GO

ALTER DATABASE [store] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [store] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [store] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [store] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO

ALTER DATABASE [store] SET QUERY_STORE = OFF
GO

ALTER DATABASE [store] SET  READ_WRITE 
GO

