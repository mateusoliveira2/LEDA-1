package solucao.questoes;

import java.util.Collection;

public class C<T> implements A<T> {

	@Override
	public void m(T obj) {
		System.out.println(obj);
	}
	
	public void metodo(Collection<T> obj){
		for(Object o: obj){
			System.out.println(o);
		}
	}
	
	public void metodo2(Collection<?> obj){
		for(Object o: obj){
			System.out.println(o);
		}
	}
	
	public void metodo3(Collection<? extends T> obj){
		for(Object o: obj){
			System.out.println(o);
		}
	}

}
