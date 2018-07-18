package huyquanghust.Blockchain;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static ArrayList<Block>  blocks;
	public static Block prevBlock;
	public static Block newBlock;
	
	public static void addBlock(String data) {
		prevBlock = blocks.get(blocks.size()-1);
		newBlock = new Block(data,prevBlock.hash);
		blocks.add(newBlock);
	}
	
	public static void initBlockchain() {
		blocks = new ArrayList<Block>();
		blocks.add(new Block("Genesis Block",""));
		
	}
	
	public static void getInforBlock(Block b) {
		System.out.println("Prev: "+b.prevBlockHash);
		System.out.println("Data: "+b.data);
		System.out.println("Hash: "+b.hash+"\n");		
	}
	
	
	
    public static void main( String[] args )
    {
       initBlockchain();
       addBlock("Send 1 BTC to Ivan");
       addBlock("Send 2 more BTC to Ivan");
       for(int i=0;i<blocks.size();i++) {
    	  getInforBlock(blocks.get(i));
       }
       
    }
}
