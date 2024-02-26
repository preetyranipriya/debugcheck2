package com.ht.debugcheck2;

import com.ht.debugcheck2.code.ICalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class Debugcheck2ApplicationTests {
@Autowired
	ICalc calc;

	@Test
	void t1() throws IOException {
		Double add = calc.add(2, 4);
		var expectedAnswer= Files.readAllLines(Paths.get("src/test/resources/answer.txt"));
				 // use streams to extract expected answer
		Assertions.assertEquals( expectedAnswer.stream().mapToDouble(d-> Double.parseDouble(d)).findFirst().getAsDouble(), add);
	}

	@Test
	void t2() throws IOException {
		Double d = calc.divide(2, 4).doubleValue(); // use casting to fix
		var expectedAnswer= 0.5;

		Assertions.assertEquals(expectedAnswer, d);
	}

	@Test
	void t3() throws IOException, InterruptedException {

		Runn runn = new Runn(calc);
		Double result;
		Thread t=new Thread(runn);
		t.start();
		t.join();

		Assertions.assertEquals(20, runn.getResult());
	}


}
@SpringBootTest
class Runn implements Runnable{


	ICalc calc;
	Double result;
	public Runn(ICalc calc){
		this.calc=calc;
	}



	@Override
	public void run() {
		result=calc.add(10,10);
	}



	public Double getResult() {


		return result;
	}
}