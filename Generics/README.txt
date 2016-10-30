URL exercises: https://docs.oracle.com/javase/tutorial/java/generics/QandE/generics-questions.html

1. M-am uitat pe rezolvare pentru ca nu am stiut cum sa o fac. Ma voi uita mai mult pe rezolvare in weekend

6. 
	public static <T extends Comparable<T>> int findFirstGreaterThan(T[] at, T elem) {
		// ...
	}

	Dupa type erasure:

	public static int findFirstGreaterThan(Comparable[] at, Comparable elem) {
		// ...
	}
	
7. metoda se compileaza (are extends Number, si se itereaza prin "list" cu n de tip Number)

9. nu se compileaza. metoda este statica.

10. nu se compileaza. Node<Circle> nu e subclasa a lui Node<Shape>.

11.se compileaza.

