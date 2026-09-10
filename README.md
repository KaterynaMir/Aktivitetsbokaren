# Aktivitetsbokaren
Ett sammanhållet Java-projekt från grundläggande beräkningar till klasser och objekt

En mindre förening erbjuder aktiviteter som deltagare kan boka. Föreningen behöver ett
Java-program som kan registrera flera bokningar, beräkna rätt pris, visa samtliga bokningar och
sammanställa bokningsvärdet. I slutversionen ska varje bokning representeras av ett objekt.

**Projektets mål**

Målet är att utveckla ett komplett konsolprogram som uppfyller samtliga krav nedan. Lösningen
ska byggas stegvis, men den slutliga inlämningen ska vara en sammanhängande och
fungerande helhet.

**Meny och huvudfunktioner**

Programmet ska visa följande meny och fortsätta tills användaren väljer att avsluta:\
AKTIVITETSBOKAREN
1. Registrera bokning
2. Visa alla bokningar
3. Visa sammanställning
4. Avsluta

Menyn ska upprepas med en loop efter varje genomfört val.
Programmet ska kunna registrera och lagra ett obegränsat antal bokningar under
samma körning.

**Registrera en bokning**

-Fråga vilken aktivitet som ska bokas: 1, 2 eller 3.\
-Fråga hur många deltagare bokningen gäller.\
-Bestäm aktivitetens pris per deltagare med hjälp av villkorssatser.\
-Beräkna bokningens slutpris.\
-Skriv ut aktivitet, antal deltagare och slutpris när bokningen registreras.

**Visa alla bokningar**

När användaren väljer att visa bokningarna ska varje registrerad bokning skrivas ut tydligt, till
exempel:\
Bokning 1: Programmeringsworkshop, 3 deltagare, 600 kr\
Bokning 2: Träningspass, 5 deltagare, 750 kr

**Visa sammanställning**

Sammanställningen ska minst visa:
-Totalt antal registrerade bokningar.\
-Sammanlagt värde för alla bokningar.\
-Antal bokningar för Programmeringsworkshop.\
-Antal bokningar för Matlagningskurs.\
-Antal bokningar för Träningspass.\
-Antal bokningar per aktivitet avser hur många bokningar som gjorts, inte hur många deltagare
de omfattar.

**Programmet ska minst innehålla:**

-En metod som visar menyn.\
-En metod som beräknar priset för en bokning.\
-En metod som registrerar en bokning och lagrar den.\
-En metod som visar alla registrerade bokningar.\
-En metod som visar sammanställningen.\
