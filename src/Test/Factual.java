package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Factual {
	int table_columns_length=0;
    int table_raws_length=0;
    ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
    boolean WRAP=false;
    int number_words=0;
    ArrayList<String> words = new ArrayList<String>();
    // Read file, fill the parameter list for the task
    void readFile(String filename) {
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader(filename));
    		String line = null;
    		line = reader.readLine();
    		String[] numbers=line.split(" ");
    		table_columns_length=Integer.parseInt(numbers[1]);
    		table_raws_length=Integer.parseInt(numbers[0]);
    		int i=0;
    		
    		while ( i<table_raws_length && (line = reader.readLine().trim()) != null) {
    			ArrayList<String> al = new ArrayList<String>();
    			//System.out.println(line);
    			for(int j=0; j<line.length();j++) {
    				String e = line.substring(j,j+1);
    				//System.out.println("E="+e);
    				al.add(e);
    			}
    			table.add(al);
    			i++;
    		}
    		
    		line = reader.readLine();
    		if(line.equals("WRAP"))WRAP=true;
    		
    		line = reader.readLine();
    		number_words=Integer.parseInt(line);
    		i=0;
    		while (i<number_words && (line = reader.readLine().trim()) != null ) {
    			words.add(line);
    			i++;
    		}
    		reader.close();
    	} catch(IOException e) {
    		System.out.println("no file found"+e.getMessage());
    	}
    	
    	printNM();
    	printTable();
    	printWRAP();
    	printWords();
    }
    //Print size of the grid
    void printNM() {
    	System.out.println( "N(y)="+table_raws_length+", M(x)="+ table_columns_length);
    }
    //Print grid
    void printTable() {
    	for(int i=0; i< table.size();i++) {
    		for(int j=0; j< table.get(i).size();j++) {
    			System.out.print(table.get(i).get(j)+",");
    		}
    		System.out.println("");
    	}
    	
    }
    //Print WRAP option
    void printWRAP() {
    	if(WRAP)System.out.println("WRAP"); else System.out.println("NO_WRAP");
    }
    //Print word list
    void printWords(){
    	for (int i=0; i< words.size();i++) {
    		System.out.println(words.get(i));
    	}
    }
    // Get positions of a letter in the grid: Position = Tuple(x,y)
    ArrayList<Tuple> getPositions(String s) {
    	ArrayList<Tuple> result = new ArrayList<Tuple>();
    	for(int i=0; i<table.size();i++) {
    		for(int j=0; j<table.get(i).size();j++) {
    			if(s.equals(table.get(i).get(j))) {
    				Tuple t = new Tuple(j,i);
    				result.add(t);
    			}
    		}
    	}
    	return result;
    }
    // Get letter from the grid by its coordinates
    String getLetter(Tuple t) {
    	int x = t.x % table_columns_length;
    	int y = t.y % table_raws_length;
    	if(x<0) x += table_columns_length;
		if(y<0) y += table_raws_length;
    	return table.get(y).get(x);
    }
    //Return words - candidates that start at 1st and go through 2nd letter of the input word
    Word getCheckWord(Tuple t1, Tuple t2, int word_length) {
    	int delta_x = t2.x-t1.x;
    	int delta_y = t2.y-t1.y;
    	if(WRAP) {
    		if(delta_x<0) delta_x += table_columns_length;
    		if(delta_y<0) delta_y += table_raws_length;
    	}

    	String result=getLetter(t1)+getLetter(t2);
    	int x=t2.x;
    	int y=t2.y;
    	for(int i=2; i< word_length; i++) {
    		int x2 = x + delta_x;
    		int y2 = y +delta_y;
    		String letter = getLetter(new Tuple(x2,y2));
    		
    		//NO WRAP:  coordinates should not go outside of the grid
    		if(!WRAP && (x2<0 || y2< 0 || x2>=table_columns_length || y2>= table_raws_length)) break;
    		//Letters should not repeat in a word
    		if(result.contains(letter)) break;
    		
    		x = x2;
    		y = y2;
    		result += letter;
    	}
    	return new Word(t1, new Tuple(x % table_columns_length,y % table_raws_length), result);
    }
    //Find word in the grid
    //First 2 letters are used to direct "straight" line that connects letters of the word
    String findword(String word) {
    	String result="NOT FOUND";
    	//Find first letter(s)
    	ArrayList<Tuple> firsts = getPositions(word.substring(0,1));
    	//Find second letter(s)
    	ArrayList<Tuple> seconds = getPositions(word.substring(1,2));
    	//Check word that start at firsts and goes through seconds
    	for(int i=0; i< firsts.size();i++) {
    		for(int j=0; j< seconds.size();j++) {
    			Word word_to_check = getCheckWord(firsts.get(i),seconds.get(j),word.length());
    			if(word_to_check.word.equals(word)) {
    				result=word_to_check.printCoordinates();
    				return result;
    			}
    		}
    	}
    	return result;
    }
    // Find each word in the grid
    void findwords() {
    	for(int i=0; i< words.size();i++) {
    		String word = words.get(i);
    		System.out.println(findword(word));
    	}
    }
    
	public Factual(String filename) {
		readFile(filename);
		findwords();
	}
	//Tuple (x,y) coordinates from the grid
	public class Tuple { 
	    public Integer x; 
	    public Integer y; 
	    public Tuple(Integer x, Integer y) { 
	        this.x = x; 
	        this.y = y; 
	    }
	}
	//class Word: word start, end in the grid, word 
	public class Word { 
	    public Tuple start; 
	    public Tuple end; 
	    public String word="";
	    public Word(Tuple t1, Tuple t2, String w) { 
	        this.start = t1; 
	        this.end = t2;
	        this.word = w;
	    }
	    
	    public String printWord() {
	    	return word+": ("+start.y+","+start.x+")("+end.y+","+end.x+")";
	    }
	    public String printCoordinates() {
	    	return "("+start.y+","+start.x+")("+end.y+","+end.x+")";
	    }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename=args[0];
		//filename="data_table2.txt";
		Factual f = new Factual(filename);
	}

}
