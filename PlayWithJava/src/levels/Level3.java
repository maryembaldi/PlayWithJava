package levels;

import models.Employee;
import java.util.*;
import java.util.stream.Collectors;
import utils.Data;

public class Level3 {
	public static void main(String[] args) {
	List<Employee> employees = Data.employees();

	/* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */	
	/* TO DO 1  hint(reduce)*/;
		String names = employees.stream().map(Employee::getName).reduce("", (s1, s2) -> s1 + " " + s2);
		System.out.println("All employee names: " + names);
						
	/* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */
		String namesMajSplit = employees.stream().map(Employee::getName).map(String::toUpperCase).collect(Collectors.joining("#"));
		System.out.println("Uppercase names separated by #: " + namesMajSplit);

	/* TO DO 3: Retourner une set d'employ�s*/
		Set<Employee> emps = employees.stream().collect(Collectors.toSet());
		System.out.println("Set of employees: " + emps);

	/* TO DO 4: Retourner une TreeSet d'employ�s (tri par nom) */
		TreeSet<Employee> emps2 = employees.stream().collect(Collectors.toCollection(() -> new TreeSet <>(Comparator.comparing(Employee::getName))));
		System.out.println("TreeSet of employees (sorted by name): " + emps2);

	/* TO DO 5: Retourner une Map qui regroupe les employ�s par salaire */
		Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
		System.out.println("Map grouping employees by salary: " + map);
		
	/* TO DO 6: Retourner une Map qui regroupe les nom des employ�s par salaire */
		Map<Integer, String> mm = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.joining(","))));
		System.out.println("Map grouping names by salary: " + mm);

	/* TO DO 7: Retourner le  min, max,average, sum,count des salaires */
		String s = employees.stream().collect(Collectors.summarizingInt(Employee::getSalary)).toString();
		System.out.println("Statistics of salaries: " + s);

	}
}
