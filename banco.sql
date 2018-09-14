-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28-Ago-2018 às 22:03
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banco`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `rm` int(6) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `bairro` varchar(80) NOT NULL,
  `sexo` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`rm`, `nome`, `endereco`, `bairro`, `sexo`) VALUES
(1, 'Fulano', 'Rua Tal', 'Jardim Tal', 'Masculino'),
(2, 'Sicrano', 'Rua 1', 'Jardim Sul', 'Feminino'),
(3, 'Beltrano', 'Rua 1', 'Jardim Norte', 'Masculino'),
(4, 'Aluno1', 'Rua 1', 'Bairro 1', 'Masculino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `coordenadores`
--

CREATE TABLE `coordenadores` (
  `rc` int(6) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `bairro` varchar(80) NOT NULL,
  `sexo` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `inspetores`
--

CREATE TABLE `inspetores` (
  `ri` int(6) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `bairro` varchar(80) NOT NULL,
  `sexo` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE `professores` (
  `rp` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `sexo` char(9) NOT NULL,
  `rc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`rm`);

--
-- Indexes for table `coordenadores`
--
ALTER TABLE `coordenadores`
  ADD PRIMARY KEY (`rc`);

--
-- Indexes for table `inspetores`
--
ALTER TABLE `inspetores`
  ADD PRIMARY KEY (`ri`);

--
-- Indexes for table `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`rp`),
  ADD KEY `FOREIGN KEY` (`rc`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alunos`
--
ALTER TABLE `alunos`
  MODIFY `rm` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `coordenadores`
--
ALTER TABLE `coordenadores`
  MODIFY `rc` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `inspetores`
--
ALTER TABLE `inspetores`
  MODIFY `ri` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `professores`
--
ALTER TABLE `professores`
  MODIFY `rp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `professores`
--
ALTER TABLE `professores`
  ADD CONSTRAINT `rc` FOREIGN KEY (`rc`) REFERENCES `coordenadores` (`rc`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
