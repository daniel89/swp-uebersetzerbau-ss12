package de.fuberlin.projectci.test.grammar;

import de.fuberlin.projectci.grammar.BNFParsingErrorException;
import de.fuberlin.projectci.grammar.Grammar;
import de.fuberlin.projectci.grammar.GrammarReader;
public class GrammarReaderTest {

	/**
	 * @param args
	 * @throws BNFParsingErrorException 
	 */
	public static void main(String[] args){
		GrammarReader grammarReader= new GrammarReader();
		System.out.println("Ungültige Grammatik:");
		try {
			Grammar g = grammarReader.readGrammar("./doc/beispielgrammatik1_ungueltig.txt");
			System.out.println(g.toString());
		} catch (BNFParsingErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nGültige Grammatik:");
		try {
			Grammar g2 = grammarReader.readGrammar("./doc/beispielgrammatik1.txt");
			System.out.println(g2.toString());
		} catch (BNFParsingErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("\nQuellsprachen-Grammatik:");
		try {
			Grammar g3 = grammarReader.readGrammar("./doc/quellsprache_bnf.txt");
			System.out.println(g3.toString());
		} catch (BNFParsingErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
