package com.hgaspar.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;





public class Calculation implements Serializable{
	
	String calculationId;
	BigDecimal a, b;
	char sign;
	BigDecimal result;
	
	
	public Calculation(BigDecimal a, BigDecimal b, char sign, BigDecimal result, String calculationId) {
		super();
		this.calculationId = calculationId;
		this.a = a;
		this.b = b;
		this.sign = sign;
		this.result = result;
	}
	
	public Calculation() {};
	/**
	 * 
	 */
	private static final long serialVersionUID = 3468006779923412449L;


	public String getCalculationId() {
		return calculationId;
	}

	public void setCalculationId(String calculationId) {
		this.calculationId = calculationId;
	}

	public char getSign() {
		return sign;
	}
	public void setSign(char sign) {
		this.sign = sign;
	}

	
	public BigDecimal getA() {
		return a;
	}
	public void setA(BigDecimal a) {
		this.a = a;
	}
	public BigDecimal getB() {
		return b;
	}
	public void setB(BigDecimal b) {
		this.b = b;
	}
	
	public BigDecimal getResult() {
		return result;
	}
	public void setResult(BigDecimal result) {
		this.result = result;
	}

	
	@Override
	public String toString() {
		return "Calculation [" + a+" "+  sign+" " + b +" = "+result+" ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + sign;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculation other = (Calculation) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (sign != other.sign)
			return false;
		return true;
	}

}
