-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 23, 2019 at 10:25 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `gsb_cr_gsk`
--

-- --------------------------------------------------------

--
-- Table structure for table `enumerer`
--

CREATE TABLE `enumerer` (
  `med_depot_legal` int(10) NOT NULL,
  `rap_num` int(10) NOT NULL,
  `off_qte` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicament`
--

CREATE TABLE `medicament` (
  `med_depot_legal` int(10) NOT NULL,
  `nom_commercial` varchar(10) NOT NULL,
  `famille` varchar(30) NOT NULL,
  `effet_therapetique` varchar(34) NOT NULL,
  `contre_indication` varchar(30) NOT NULL,
  `prix_echantillon` float NOT NULL,
  `typemedicament` varchar(16) NOT NULL,
  `qte_stock` int(10) NOT NULL,
  `date_peremption` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicament`
--

INSERT INTO `medicament` (`med_depot_legal`, `nom_commercial`, `famille`, `effet_therapetique`, `contre_indication`, `prix_echantillon`, `typemedicament`, `qte_stock`, `date_peremption`) VALUES
(1, 'doliprane', 'Antalgiques', 'fievre', 'interdit -12ans', 12.5, 'comprime', 500, '2017-10-01'),
(2, 'spasfon', 'Allergologie ', 'maux de ventre', '-12 ans', 13.5, 'soluble', 400, '2017-10-02'),
(3, 'maxilase', 'Antalgiques', 'contre la toux', 'interdit -12ans', 3.5, 'comprime', 300, '2017-10-03'),
(4, 'smecta', 'Métabolisme et nutrition', 'contre la diarrhee', '-12 ans', 5.5, 'soluble', 200, '2017-10-04'),
(5, 'juvamine', 'Métabolisme et nutrition', 'contre la fatigue', 'interdit -12ans', 4.5, 'gelule', 100, '2017-10-05'),
(6, 'biafine', 'Anti-inflammatoires', 'anti brulure', 'interdit au moins de 3 mois', 7.5, 'spray', 50, '2017-10-06');

-- --------------------------------------------------------

--
-- Table structure for table `praticien`
--

CREATE TABLE `praticien` (
  `pra_code` int(10) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `adresse` varchar(34) NOT NULL,
  `ville` varchar(17) NOT NULL,
  `code_postal` int(6) NOT NULL,
  `numero_tel` int(10) NOT NULL,
  `type_praticien` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `praticien`
--

INSERT INTO `praticien` (`pra_code`, `nom`, `prenom`, `adresse`, `ville`, `code_postal`, `numero_tel`, `type_praticien`) VALUES
(2, 'levy', 'arie', '15 avenue paul herbe', 'sarcelles', 95200, 781987673, 'medecin'),
(3, 'berguig', 'binyamin', '2 rue de balzac', 'paris', 75019, 542157510, 'dentiste'),
(4, 'haddad', 'chimone', '45 rue paul hervais', 'sarcelles', 95200, 658492571, 'dentiste'),
(5, 'aidan', 'yohan', 'rue saint gobain', 'stains', 93200, 542157510, 'audioprothesiste');

-- --------------------------------------------------------

--
-- Table structure for table `rapport_visite`
--

CREATE TABLE `rapport_visite` (
  `rap_num` int(10) NOT NULL,
  `rap_date` varchar(10) NOT NULL,
  `rap_bilan` varchar(20) NOT NULL,
  `rap_motif` varchar(34) NOT NULL,
  `vis_matricule` int(10) NOT NULL,
  `pra_code` int(10) NOT NULL,
  `medicament_offert` varchar(10) NOT NULL,
  `nombre_echantillon_offert` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rapport_visite`
--

INSERT INTO `rapport_visite` (`rap_num`, `rap_date`, `rap_bilan`, `rap_motif`, `vis_matricule`, `pra_code`, `medicament_offert`, `nombre_echantillon_offert`) VALUES
(1, '2017-10-04', 'realise', 'nouvelle emballage', 4, 2, 'doliprane', 10),
(2, '2015-06-23', 'en cours', 'nouveau medicament', 3, 3, 'doliprane', 5),
(3, '2013-10-07', 'en cours', 'mise a jour notice', 2, 4, 'biafine', 4),
(4, '2017-10-13', 'realisee', 'modification', 4, 5, 'maxilase', 6),
(5, '2017-10-12', 'en discution', 'prix du medicament', 2, 3, 'smecta', 5);

-- --------------------------------------------------------

--
-- Table structure for table `visiteur`
--

CREATE TABLE `visiteur` (
  `vis_matricule` int(10) NOT NULL,
  `vis_nom` varchar(10) NOT NULL,
  `vis_prenom` varchar(10) NOT NULL,
  `vis_adresse` varchar(34) NOT NULL,
  `vis_ville` varchar(17) NOT NULL,
  `vis_cp` int(6) NOT NULL,
  `vis_dateembauche` varchar(10) NOT NULL,
  `vis_secteur` varchar(10) NOT NULL,
  `vis_labo` varchar(10) NOT NULL,
  `role` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visiteur`
--

INSERT INTO `visiteur` (`vis_matricule`, `vis_nom`, `vis_prenom`, `vis_adresse`, `vis_ville`, `vis_cp`, `vis_dateembauche`, `vis_secteur`, `vis_labo`, `role`) VALUES
(1, 'naccache', 'yossef', 'avenue de flandre', 'paris', 75019, '2010-04-17', '7', 'curial', 1),
(2, 'ohayon', 'bryan', 'rue crimee', 'paris', 75019, '2017-05-01', '7', 'curial', 0),
(3, 'dahan', 'kevin', 'dausmenil', 'creteil ', 94000, '2012-07-09', '7', 'curial', 0),
(4, 'taieb', 'elone', 'rue victor hugo', 'paris', 75011, '2006-04-09', '7', 'curial', 1),
(5, 'aaa', 'bbb', 'ccc', 'ddd', 55555, '2013-09-17', 'est', 'paris', 0),
(6, 'a', 'b', 'mmm', 'paris', 75012, '2013-05-12', 'r', 'h', 1),
(7, 'baranes', 'levana', 'Paris', 'Paris', 75019, '2019-04-05', 'est', 'Nante', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `enumerer`
--
ALTER TABLE `enumerer`
  ADD PRIMARY KEY (`med_depot_legal`,`rap_num`),
  ADD KEY `rap_num` (`rap_num`),
  ADD KEY `med_depot_legal` (`med_depot_legal`) USING BTREE;

--
-- Indexes for table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`med_depot_legal`);

--
-- Indexes for table `praticien`
--
ALTER TABLE `praticien`
  ADD PRIMARY KEY (`pra_code`);

--
-- Indexes for table `rapport_visite`
--
ALTER TABLE `rapport_visite`
  ADD PRIMARY KEY (`rap_num`),
  ADD KEY `vis_matricule` (`vis_matricule`),
  ADD KEY `pra_code` (`pra_code`);

--
-- Indexes for table `visiteur`
--
ALTER TABLE `visiteur`
  ADD PRIMARY KEY (`vis_matricule`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `medicament`
--
ALTER TABLE `medicament`
  MODIFY `med_depot_legal` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `praticien`
--
ALTER TABLE `praticien`
  MODIFY `pra_code` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rapport_visite`
--
ALTER TABLE `rapport_visite`
  MODIFY `rap_num` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `visiteur`
--
ALTER TABLE `visiteur`
  MODIFY `vis_matricule` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `enumerer`
--
ALTER TABLE `enumerer`
  ADD CONSTRAINT `enumerer_ibfk_1` FOREIGN KEY (`med_depot_legal`) REFERENCES `medicament` (`med_depot_legal`),
  ADD CONSTRAINT `enumerer_ibfk_2` FOREIGN KEY (`rap_num`) REFERENCES `rapport_visite` (`rap_num`),
  ADD CONSTRAINT `enumerer_ibfk_3` FOREIGN KEY (`med_depot_legal`) REFERENCES `medicament` (`med_depot_legal`),
  ADD CONSTRAINT `enumerer_ibfk_4` FOREIGN KEY (`med_depot_legal`) REFERENCES `medicament` (`med_depot_legal`),
  ADD CONSTRAINT `enumerer_ibfk_5` FOREIGN KEY (`rap_num`) REFERENCES `rapport_visite` (`rap_num`),
  ADD CONSTRAINT `enumerer_ibfk_6` FOREIGN KEY (`med_depot_legal`) REFERENCES `medicament` (`med_depot_legal`);

--
-- Constraints for table `rapport_visite`
--
ALTER TABLE `rapport_visite`
  ADD CONSTRAINT `rapport_visite_ibfk_1` FOREIGN KEY (`vis_matricule`) REFERENCES `visiteur` (`vis_matricule`),
  ADD CONSTRAINT `rapport_visite_ibfk_2` FOREIGN KEY (`pra_code`) REFERENCES `praticien` (`pra_code`);
