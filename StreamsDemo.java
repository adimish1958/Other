import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;; 

public class StreamsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("aditya");
		al.add("abhishek");
		al.add("dona");
		al.add("absa");
		al.add("owl");
		
		String arr[] = {"asha", "abha", "lata", "soniya", "santa"};
		List<String> al1 =  Arrays.asList(arr);
		
		
		/// stream, filter and forEach
		Long c=al.stream().filter(s->s.startsWith("a")).count();
		System.out.println("names starting with A " + c);
		System.out.println("all strings with length greater than 0");
		al.stream().filter(s->s.length()>0).forEach(s->System.out.println(s));
		System.out.println("strings with length greater than 0 limit 3");
		al.stream().filter(s->s.length()>0).limit(3).forEach(s->System.out.println(s));
		
		
		//map used to update the values in the stream
		System.out.println("strings with ends with a and then update to uppercase");
		al.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("strings with ends with a, sort it and then update to uppercase");
		
		al.stream().filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("merge two lists then sort and then uppercase");
		
		Stream<String> newStream=Stream.concat(al.stream(), al1.stream());
		
		newStream.filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//match to check whether value exist in streams or not
		boolean flag=Stream.concat(al.stream(), al1.stream()).anyMatch(s->s.equalsIgnoreCase("abha"));
		System.out.println("whether abha value exist in the list? "+ flag);
		
		//collect to collect output as list and return
		
		List<String> al2=al.stream().filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(al2);
		
		//print unique number from the array
		System.out.println("print unique number from the array");
		List<Integer> al3 =Arrays.asList(1,2,2,4,0,3,7,5,3,0,9);
		al3.stream().distinct().forEach(s->System.out.print(s+","));
		
		//sorted array for unique numbers array
		System.out.println("sorted array for unique numbers array");
		al3.stream().distinct().sorted().forEach(s->System.out.print(s+","));
		
		

	}

}
