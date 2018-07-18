package huyquanghust.Blockchain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
	
	public long timeStamp;
	public String data;
	public String prevBlockHash;
	public String hash;
	
	public Block(String data,String previousHash) {
		this.data = data;
		this.prevBlockHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = setHash();
	}
	
	
	public String setHash() {
		String result = "";
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			String header = this.prevBlockHash + Long.toString(this.timeStamp) + this.data;
		//	System.out.println(header);
			try {
				byte[] hash = {};
				hash = sha256.digest(header.getBytes("UTF-8"));
				for(int i=0;i<hash.length;i++) {
					String hex = Integer.toHexString(0xff & hash[i]);
					if (hex.length() == 1)
						result += "0";
					result += hex;
					
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
