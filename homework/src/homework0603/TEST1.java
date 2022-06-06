package homework0603;

	interface Animal {
	    void cry();
	}
	class Cat implements Animal{
	    @Override
	    public void cry() {
	        System.out.println("냐옹");
	    }
	}
	class Dog implements Animal{
	    @Override
	    public void cry() {
	        System.out.println("멍멍");
	    }
	}
}
