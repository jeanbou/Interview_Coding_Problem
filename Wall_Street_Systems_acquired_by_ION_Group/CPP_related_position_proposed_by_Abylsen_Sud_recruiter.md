## Three Interview Questions

**Dynamic_cast, static_cast**

###Question 1 :###


```
using std::cout;
using std::endl;
class complexNumbers {
  double real, img;
public:
  complexNumbers() : real(0), img(0) { }
  complexNumbers(const complexNumbers& c) { real = c.real; img = c.img; }
  explicit complexNumbers( double r, double i = 0.0) { real = r; img = i; }
  friend void display(complexNumbers cx);
};
void display(complexNumbers cx){
  cout<< Real Part: <<cx.real<< ; Imag Part: <<cx.img<<endl;
}
int main() {
  complexNumbers one(1);
  display(one);
  display(200);
  return 0;
}
```

###What will happen ?### 

*ERROR COMPILATIONS due to this line display 200 because explicit complex numbers doesn't allow the implicit conversion*


###Question 2 :###


```
class A 
{
	A(){this->Foo();}
	void Foo(){print("A->Foo() ");}
}
class B : public A 
{
	B(){this->Foo();}
	void Foo(){print("B->Foo() ");}
}
class C : public B 
{
	C(){this->Foo();}
}

int main()
{
	C myObjetC;
	myObjetC.Foo();
}
```


###What is printed ?###

**A->Foo() B->Foo() B->Foo() B->Foo()**
A->Foo() A->Foo() B->Foo() B->Foo()
B->Foo() B->Foo() A->Foo() B->Foo()
A->Foo() B->Foo() A->Foo() B->Foo()


###Question 3 :###


```
int main() {
	MyClass a,b;
	Myclass pb = new MyClass;

}
```


###How many time the destructeur is called ?###

Never
**Twice**
Third