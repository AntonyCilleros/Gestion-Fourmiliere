# Gestion-Fourmiliere

## Un jeu de gestion d'une fourmilière

Ce projet a pour objectif de réaliser un jeu de gestion de fourmilière en essayant d'être un temps soit peu fidèle à la réalité avec les différents type de fourmis, un système de nourriture et d'évenements aléatoire. Deux threads marchent pendant la partie, un gérant l'actualisation du GUI et l'autre gérant les calculs en fond.

Projet réalisé par Maxime Albertelli, Antony Cilleros, Antoine Welter

## Manuel d'utilisation

Ce jeu de gestion représente une fourmilière. Il s’agit de bien répartir la quantité de chaque type de fourmis afin de préserver la fourmilière et sa reine.

### Les différents types de fourmis

Il y a 3 types de fourmis différentes : 

Les soldats : Les soldats sont des fourmis plus puissantes que les autres, elles apporteront des points de puissance nécessaire à la protection de la fourmilière.
Les nourricières : Les nourricières ont pour objectif d’assurer l'éclosion des larves et ainsi faire prospérer la fourmilière. Tous les 5 unités de temps passé, l’éclosion a lieu, et la quantité de nouvelles fourmis sera équivalente au nombre de nourricières, si il y a plus de larves que de nourricières, les larves en trop ne pourront pas devenir des fourmis et seront perdues.
Les aventurières : Les aventurières sont les courageuses fourmis qui sortent de la fourmilière afin de ramener de la nourriture. La quantité de nourriture baisse du même nombre de fourmis totales, mais pour chaque aventurière dans la colonie, la quantité de nourriture est augmentée de 3 à chaque unité de temps.

Le joueur peut déterminer le pourcentage de chaque type de fourmis généré à chaque éclosion.
Le joueur peut aussi mettre pause afin de prendre le temps de réfléchir et de prendre du recul sur la situation.

### Les envahisseurs

De manière aléatoire un envahisseur viendra mettre sans dessus-dessous la fourmilière, il en existe différents types aussi se caractérisant uniquement sur une plage de puissance.

(du moins au plus puissant) types d’envahisseur : 

Scarabé (10-35 de puissance)
Mante religieuse (70-100 de puissance)
Guêpe (70-120 de puissance)
Terminator (100 000-1 000 000 de puissance, impossible)

Pour se défendre de ces envahisseurs la fourmilière doit avoir une puissance équivalente ou supérieure à celle de l’envahisseur (d’où l’utilité des soldats). Si il s’avère que la fourmilière est moins puissante que l’envahisseur alors celle ci perdra une quantité de fourmis équivalent à 70-80% de toutes les fourmis, si la fourmilière gagne elle perdra uniquement entre 5-10% de son nombre.

### L'hiver

De manière aléatoire aussi l'hiver arrivera. Quand l'hiver est là, les aventurières ramènent moins de nourriture (1 au lieu de 3) ce qui risque de provoquer la famine et faire mourir de faim des fourmis.
