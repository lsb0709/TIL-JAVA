package com.test.과제.grade;

public class PassFailEvaluation implements GradeEvaluation{

	@Override
	public String getGrade(int point) {
		if (point >= 70) 
			return "P";
		else
		    return "F";
	}
}
