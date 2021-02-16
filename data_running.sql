-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2021 at 11:06 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_running`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_event`
--

CREATE TABLE `add_event` (
  `id_add` int(20) NOT NULL,
  `id_user` int(10) NOT NULL,
  `pic_event` varchar(200) DEFAULT NULL,
  `name_event` varchar(100) DEFAULT NULL,
  `name_producer` varchar(100) DEFAULT NULL,
  `date_reg_start` varchar(20) DEFAULT NULL,
  `date_reg_end` varchar(20) DEFAULT NULL,
  `bank` varchar(100) NOT NULL,
  `num_bank` varchar(100) NOT NULL,
  `objective` varchar(2000) DEFAULT NULL,
  `detail` varchar(5000) DEFAULT NULL,
  `name_organizer` varchar(50) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `type` int(1) NOT NULL,
  `status_event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `add_event`
--

INSERT INTO `add_event` (`id_add`, `id_user`, `pic_event`, `name_event`, `name_producer`, `date_reg_start`, `date_reg_end`, `bank`, `num_bank`, `objective`, `detail`, `name_organizer`, `tel`, `type`, `status_event`) VALUES
(182, 51, 'https://firebasestorage.googleapis.com/v0/b/vistual-running.appspot.com/o/images%2Fe5921e4b-3de4-4846-8369-38f4ebf255bd?alt=media&token=3901c3ee-100a-4d6a-b61c-ec8cbb5a7079', 'One Love Run', 'กัน', '14/2/2021', '28/2/2021', 'ธนาคารกสิกรไทย', '11569871', 'test', 'test', 'โรงพยาบาลพระมุงกุฎ', '0923956498', 1, 1),
(183, 51, 'https://firebasestorage.googleapis.com/v0/b/vistual-running.appspot.com/o/images%2Fc53f5b0d-2a52-4856-8dad-e43b3b77cfa0?alt=media&token=48a80f42-cd93-4b50-9aa6-695d5d425704', 'KKU RUN FOR LOVE', 'KKU54', '15/2/2021', '28/2/2021', 'ธนาคารทหารไทย', '123-4567-890', 'test', 'test', 'Satamp', '0923956498', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `detail_distance`
--

CREATE TABLE `detail_distance` (
  `Detail_id` int(11) NOT NULL,
  `id_add` int(11) NOT NULL,
  `name_event` varchar(40) NOT NULL,
  `name_distance` varchar(40) NOT NULL,
  `distance` int(3) NOT NULL,
  `price` int(10) NOT NULL,
  `num_register` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_distance`
--

INSERT INTO `detail_distance` (`Detail_id`, `id_add`, `name_event`, `name_distance`, `distance`, `price`, `num_register`) VALUES
(69, 182, 'One Love Run', 'Fun Run', 4, 200, 150),
(70, 182, 'One Love Run', 'MINI MARATHON', 11, 200, 200),
(71, 183, 'KKU RUN FOR LOVE', 'Fun Run', 4, 200, 20),
(72, 183, 'KKU RUN FOR LOVE', 'Mini Marathon', 11, 200, 50),
(73, 183, 'KKU RUN FOR LOVE', 'Haft narathon', 21, 200, 80);

-- --------------------------------------------------------

--
-- Table structure for table `history_payment`
--

CREATE TABLE `history_payment` (
  `id_history_pament` int(10) NOT NULL,
  `id_user` int(10) NOT NULL,
  `id_add` int(10) NOT NULL,
  `image_link` varchar(200) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(5) NOT NULL,
  `bank` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `history_payment`
--

INSERT INTO `history_payment` (`id_history_pament`, `id_user`, `id_add`, `image_link`, `date`, `time`, `bank`) VALUES
(23, 58, 182, 'https://firebasestorage.googleapis.com/v0/b/vistual-running.appspot.com/o/images%2Faa46708a-9672-43e0-955f-cc0d214262b3?alt=media&token=5d864eb2-c41c-4ea4-93fd-ebd128ff4e35', '14/2/2021', '10:21', 'ธนาคารกรุงศรีอยุธยา'),
(24, 58, 183, 'https://firebasestorage.googleapis.com/v0/b/vistual-running.appspot.com/o/images%2Fb271d894-b2c1-4d01-be7e-28402b2053af?alt=media&token=bdd75667-c194-4149-8a0b-38a3b8d82eda', '15/2/2021', '11:58', 'ธนาคารซีไอเอ็มบีไทย');

-- --------------------------------------------------------

--
-- Table structure for table `history_uploadstatic`
--

CREATE TABLE `history_uploadstatic` (
  `id_history_UploadStatic` int(10) NOT NULL,
  `id_user` int(10) NOT NULL,
  `id_add` int(10) NOT NULL,
  `date` varchar(100) NOT NULL,
  `distance` float(10,2) NOT NULL,
  `cal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `history_uploadstatic`
--

INSERT INTO `history_uploadstatic` (`id_history_UploadStatic`, `id_user`, `id_add`, `date`, `distance`, `cal`) VALUES
(9, 58, 182, '14/2/2021', 4.35, '500'),
(10, 58, 183, '16/2/2021', 4.35, '130'),
(11, 58, 183, '16/2/2021', 4.35, '130'),
(12, 58, 183, '16/2/2021', 4.35, '130');

-- --------------------------------------------------------

--
-- Table structure for table `reg_address`
--

CREATE TABLE `reg_address` (
  `id_address` int(11) NOT NULL,
  `id_user` int(10) NOT NULL,
  `id_add` int(10) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `District` varchar(100) NOT NULL,
  `MueangDistrict` varchar(100) NOT NULL,
  `province` varchar(20) NOT NULL,
  `Country_number` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Tel` varchar(20) NOT NULL,
  `transport` varchar(20) NOT NULL,
  `pacel_number` varchar(11) NOT NULL,
  `type_submit_reward` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reg_address`
--

INSERT INTO `reg_address` (`id_address`, `id_user`, `id_add`, `Address`, `District`, `MueangDistrict`, `province`, `Country_number`, `Name`, `Tel`, `transport`, `pacel_number`, `type_submit_reward`) VALUES
(55, 58, 182, 'หอพักฟิวเจอร์', 'ศิลา', 'เมือง', 'ขอนแก่น', '40000', 'กิตินันท์ คนสอน', '0923956498', 'EMS', '45646545646', 0),
(56, 58, 183, 'test', 'test', 'test', 'test', 'test', 'Satamp', '0923956498', 'EMS', '4567891263', 0);

-- --------------------------------------------------------

--
-- Table structure for table `reg_event`
--

CREATE TABLE `reg_event` (
  `id_reg_event` int(11) NOT NULL,
  `id_add` int(40) NOT NULL,
  `id_user` int(10) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `Tel` varchar(20) NOT NULL,
  `id_card` varchar(50) NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `blood` varchar(5) NOT NULL,
  `distance` varchar(20) NOT NULL,
  `emergency` varchar(20) NOT NULL,
  `relation` varchar(10) NOT NULL,
  `relationTel` varchar(20) NOT NULL,
  `name_event` varchar(50) DEFAULT NULL,
  `name_producer` varchar(40) NOT NULL,
  `pic_event` varchar(1000) NOT NULL,
  `status_reward` int(2) NOT NULL,
  `status_send` int(10) NOT NULL,
  `type_submit` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reg_event`
--

INSERT INTO `reg_event` (`id_reg_event`, `id_add`, `id_user`, `first_name`, `last_name`, `Tel`, `id_card`, `nationality`, `blood`, `distance`, `emergency`, `relation`, `relationTel`, `name_event`, `name_producer`, `pic_event`, `status_reward`, `status_send`, `type_submit`) VALUES
(111, 182, 58, 'kitinun', 'khonson', '0923956498', '1300101186415', 'thai', 'A', '4', 'dad', 'ญาติ', '1148', 'One Love Run', 'กัน', 'https://firebasestorage.googleapis.com/v0/b/vistual-running.appspot.com/o/images%2Fe5921e4b-3de4-4846-8369-38f4ebf255bd?alt=media&token=3901c3ee-100a-4d6a-b61c-ec8cbb5a7079', 1, 1, 1),
(112, 183, 58, 'satamp', 'satamp', '0923956498', '1300101186415', 'thai', 'AB', '11', 'Dad', 'มารดา', '044275378', 'KKU RUN FOR LOVE', 'KKU54', 'https://firebasestorage.googleapis.com/v0/b/vistual-running.appspot.com/o/images%2Fc53f5b0d-2a52-4856-8dad-e43b3b77cfa0?alt=media&token=48a80f42-cd93-4b50-9aa6-695d5d425704', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(4) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `Tel` varchar(10) NOT NULL,
  `id_card` varchar(15) NOT NULL,
  `bd_date` varchar(20) NOT NULL,
  `weight` varchar(10) CHARACTER SET utf8 NOT NULL,
  `height` varchar(10) CHARACTER SET utf8 NOT NULL,
  `type` varchar(20) NOT NULL,
  `Status` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `first_name`, `last_name`, `email`, `password`, `gender`, `Tel`, `id_card`, `bd_date`, `weight`, `height`, `type`, `Status`) VALUES
(51, 'kitinun', 'khonson', 'kitinun@kkumail.com', '1234', 'ชาย', '', '', '7/12/2020', '', '', 'ผู้จัดกิจกรรม', ''),
(52, 'Satamp', 'Sumalai', 'satamp@kkumail.com', '1234', 'ชาย', '', '', '7/12/2020', '', '', 'นักวิ่ง', ''),
(53, 'b', 'b', 'b', 'b', 'หญิง', '', '', '1/12/2020', '', '', 'นักวิ่ง', ''),
(54, 'a', 'a', 'a', 'a', 'ชาย', '', '', '1/12/2020', '', '', 'ผู้จัดกิจกรรม', ''),
(55, 'gun', 'gun', 's', 's', 'ชาย', '', '', '8/12/2020', '', '', 'ผู้จัดกิจกรรม', ''),
(56, 'satamp', 'satamp', 'w', 'w', 'ชาย', '', '', '8/12/2020', '', '', 'นักวิ่ง', ''),
(57, 'satamp', 'satamp', 'f', 'f', 'ชาย', '', '', '8/12/2020', '', '', 'ผู้จัดกิจกรรม', ''),
(58, 'กิตินันท์', 'คนสอน', 't', 't', 'ชาย', '020', '020', '06/08/2541', '', '', 'นักวิ่ง', '');

-- --------------------------------------------------------

--
-- Table structure for table `user_admin`
--

CREATE TABLE `user_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_admin`
--

INSERT INTO `user_admin` (`id`, `username`, `password`) VALUES
(0, 'admin2', '1234'),
(1, 'admin1', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_event`
--
ALTER TABLE `add_event`
  ADD PRIMARY KEY (`id_add`);

--
-- Indexes for table `detail_distance`
--
ALTER TABLE `detail_distance`
  ADD PRIMARY KEY (`Detail_id`);

--
-- Indexes for table `history_payment`
--
ALTER TABLE `history_payment`
  ADD PRIMARY KEY (`id_history_pament`);

--
-- Indexes for table `history_uploadstatic`
--
ALTER TABLE `history_uploadstatic`
  ADD PRIMARY KEY (`id_history_UploadStatic`);

--
-- Indexes for table `reg_address`
--
ALTER TABLE `reg_address`
  ADD PRIMARY KEY (`id_address`);

--
-- Indexes for table `reg_event`
--
ALTER TABLE `reg_event`
  ADD PRIMARY KEY (`id_reg_event`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `user_admin`
--
ALTER TABLE `user_admin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `add_event`
--
ALTER TABLE `add_event`
  MODIFY `id_add` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=184;

--
-- AUTO_INCREMENT for table `detail_distance`
--
ALTER TABLE `detail_distance`
  MODIFY `Detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT for table `history_payment`
--
ALTER TABLE `history_payment`
  MODIFY `id_history_pament` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `history_uploadstatic`
--
ALTER TABLE `history_uploadstatic`
  MODIFY `id_history_UploadStatic` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `reg_address`
--
ALTER TABLE `reg_address`
  MODIFY `id_address` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `reg_event`
--
ALTER TABLE `reg_event`
  MODIFY `id_reg_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
