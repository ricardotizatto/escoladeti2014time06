package br.unicesumar.escoladeti.encrypt;

import static org.fest.assertions.Assertions.assertThat;
import liquibase.util.MD5Util;

import org.junit.Test;

public class MD5UtilTest {
	
	@Test
	public void testConvertStringToMD5() {
		assertThat(MD5Util.computeMD5("123mudar")).isEqualTo("89794b621a313bb59eed0d9f0f4e8205");
		assertThat(MD5Util.computeMD5("RobsonAlecioSomera")).isEqualTo("49116f5aefa284d8cfd578448f1edce4");
	}

}
