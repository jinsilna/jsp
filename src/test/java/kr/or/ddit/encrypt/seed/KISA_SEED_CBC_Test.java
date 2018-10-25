package kr.or.ddit.encrypt.seed;

import static org.junit.Assert.*;

import org.junit.Test;

public class KISA_SEED_CBC_Test {

	/**
	 * Method : encrypttest
	 * 작성자 : pc07
	 * 변경이력 :
	 * Method 설명 : seed encrypt test 
	 */
	@Test
	public void encryptTest() {
		
		/***Given***/
		String pass = "brownpass";

		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt);
		
		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(pass, decrypt);
		
	}
}
