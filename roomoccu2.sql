--
-- Datenbank: `roomoccu`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `etage`
--

CREATE TABLE `etage` (
  `EtageId` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `etage`
--

INSERT INTO `etage` (`EtageId`, `Name`) VALUES
(1, 'Erdgeschoss'),
(2, 'Obergeschoss');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `mieter`
--

CREATE TABLE `mieter` (
  `MieterID` int(10) NOT NULL,
  `Name` text NOT NULL,
  `Vorname` text NOT NULL,
  `Einheitsname` text NOT NULL,
  `NutzerID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `mieter`
--

INSERT INTO `mieter` (`MieterID`, `Name`, `Vorname`, `Einheitsname`, `NutzerID`) VALUES
(1, 'Noack', 'Ian', 'Ian Noack', 1),
(2, 'aaa', 'aaa', 'aaa aaa', 2),
(3, 'Folde', 'Tobias', 'Tobias Folde', 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `nutzer`
--

CREATE TABLE `nutzer` (
  `NutzerID` int(10) NOT NULL,
  `Nutzername` text NOT NULL,
  `Passwort` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `nutzer`
--

INSERT INTO `nutzer` (`NutzerID`, `Nutzername`, `Passwort`) VALUES
(1, 'Ian', 'Noack'),
(2, 'aaa', 'aaa'),
(3, 'Tobias', 'Folde');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `plan`
--

CREATE TABLE `plan` (
  `planId` int(11) NOT NULL,
  `datum` date NOT NULL,
  `raumID` int(11) NOT NULL,
  `von` time NOT NULL,
  `bis` time NOT NULL,
  `MieterId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `plan`
--

INSERT INTO `plan` (`planId`, `datum`, `raumID`, `von`, `bis`, `MieterId`) VALUES
(1, '2017-01-04', 3, '13:00:00', '14:00:00', 2),
(2, '2017-01-01', 6, '10:30:00', '11:00:00', 1),
(3, '2017-01-02', 4, '09:30:00', '10:40:00', 1),
(4, '2017-01-01', 3, '18:00:00', '18:10:00', 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rooms`
--

CREATE TABLE `rooms` (
  `RaumId` int(3) NOT NULL,
  `EtageID` int(20) NOT NULL,
  `Zimmer` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `rooms`
--

INSERT INTO `rooms` (`RaumId`, `EtageID`, `Zimmer`) VALUES
(1, 1, 'Köln'),
(2, 1, 'München'),
(3, 1, 'Berlin'),
(4, 1, 'Bonn'),
(5, 2, 'Paris'),
(6, 2, 'London'),
(7, 2, 'Wien'),
(8, 2, 'Zurich');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `etage`
--
ALTER TABLE `etage`
  ADD PRIMARY KEY (`EtageId`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indizes für die Tabelle `mieter`
--
ALTER TABLE `mieter`
  ADD PRIMARY KEY (`MieterID`),
  ADD KEY `NutzerID` (`NutzerID`);

--
-- Indizes für die Tabelle `nutzer`
--
ALTER TABLE `nutzer`
  ADD PRIMARY KEY (`NutzerID`);

--
-- Indizes für die Tabelle `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`planId`),
  ADD KEY `raumID` (`raumID`);

--
-- Indizes für die Tabelle `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`RaumId`),
  ADD UNIQUE KEY `Zimmer` (`Zimmer`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `etage`
--
ALTER TABLE `etage`
  MODIFY `EtageId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT für Tabelle `mieter`
--
ALTER TABLE `mieter`
  MODIFY `MieterID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT für Tabelle `nutzer`
--
ALTER TABLE `nutzer`
  MODIFY `NutzerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT für Tabelle `plan`
--
ALTER TABLE `plan`
  MODIFY `planId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `mieter`
--
ALTER TABLE `mieter`
  ADD CONSTRAINT `mieter_ibfk_1` FOREIGN KEY (`NutzerID`) REFERENCES `nutzer` (`NutzerID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
