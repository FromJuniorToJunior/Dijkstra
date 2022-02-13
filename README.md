# Dijkstra
Twoim zadaniem jest zaimplementowanie oprogramowania do nawigacji, które pozwoli na 
wyszukiwanie najkrótszych tras dla samochodów pomiędzy różnymi miejscowościami. 
1. Zdefiniuj klasy: 
• Wierzchołek z polami przechowującymi jego nazwę, referencję do 
poprzednika, koszt dotarcia oraz kolekcję obiektów klasy Krawedz, które 
wychodzą z danego Wierzcholka
• Krawedz przechowującą Wierzcholek, do którego prowadzi oraz koszt dotarcia 
do niego (to, z którego Wierzcholka wychodzi dana Krawedz, wiemy, ponieważ 
powinna ona znajdować się na jego prywatnej liście Krawedzi)
• Graf jako kolekcję Wierzcholkow wraz z wychodzącymi z nich Krawedziami
Jeśli czujesz taką potrzebę, możesz dodać również własne pola. Pamiętaj tylko o tym, 
żeby cała struktura pozostawała spójna.
2. Zaimplementuj algorytm Dijkstry do wyznaczania najkrótszych ścieżek w grafie. 
Wykorzystaj utworzoną wcześniej strukturę klas. Algorytm ma przyjmować w 
argumencie jedynie obiekt klasy Graf.
3. Zaimplementuj parser obsługujący wejście z pliku tekstowego, które będzie określało 
ilość wierzchołków składających się na graf, po spacji indeks wierzchołka, od którego 
startujemy (wierzchołki są iterowane od 0), następnie w nowych liniach nazwy 
kolejnych wierzchołków, a na końcu krawędzie (wierzchołek od, wierzchołek do, 
waga). Przykładowy plik:
8 0
Warszawa
Bialystok
Zambrow
Lomza
Ostrow Mazowiecka
Ostroleka
Wyszkow
Augustow
0 6 60
6 0 60
0 5 125
5 0 125
6 4 40
4 6 40
6 5 70
5 6 70
5 4 40
5 3 35
3 5 35
3 1 80
1 3 80
3 2 25
2 3 25
4 5 40
4 3 45
4 2 30
2 4 30
2 1 70
1 2 70
1 7 90
7 1 90
3 7 105
4. Twój program powinien wczytywać przy użyciu parsera wybrany plik tekstowy, 
przetwarzać go, generować odpowiednią strukturę klas, dostarczać ją do algorytmu 
Dijkstry i wypisywać w konsoli przeliczone najkrótsze ścieżki. Wyjście ma zawierać: 
miejscowość od, po strzałce miejscowość do i po dwukropku kolejne miejscowości, 
przez które należy przejechać oddzielone myślnikami. Na koniec, po przecinku ma być 
wyrażona sumaryczna odległość w kilometrach. Np. dla podanego wyżej pliku output 
ma mieć postać:
Warszawa -> Warszawa: Warszawa, odleglosc: 0km
Warszawa -> Bialystok: Warszawa - Wyszkow - Ostrow Mazowiecka - Zambrow - Bialystok, odleglosc: 200km
Warszawa -> Zambrow: Warszawa - Wyszkow - Ostrow Mazowiecka - Zambrow, odleglosc: 130km
Warszawa -> Lomza: Warszawa - Wyszkow - Ostrow Mazowiecka - Lomza, odleglosc: 145km
Warszawa -> Ostrow Mazowiecka: Warszawa - Wyszkow - Ostrow Mazowiecka, odleglosc: 100km
Warszawa -> Ostroleka: Warszawa - Ostroleka, odleglosc: 125km
Warszawa -> Wyszkow: Warszawa - Wyszkow, odleglosc: 60km
Warszawa -> Augustow: Warszawa - Wyszkow - Ostrow Mazowiecka - Lomza - Augustow, odleglosc: 250km
