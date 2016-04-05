package transporte;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class Main {

	
	private static void createCoordenada(Coordenada coordenada) {
		coordenada.setLatitude((long) 10);
		coordenada.setLongitude((long) 10);
	}
	
	private static void createEndereco(Endereco endereco, Coordenada coordenada) {
		endereco.setBairro("Bairro do Teste");
		endereco.setCidade("Cidade do Teste");
		endereco.setRua("Rua do Teste");
		endereco.setEstado("Estado do Teste");
		endereco.setCoordenada(coordenada);
	}
	
	private static void createCondutor(Condutor condutor, Endereco endereco) {
		condutor.setLogin("condutor_123");
		condutor.setNome("Condutor");
		condutor.setPassword("1q2w3e4r");
		List <Endereco> enderecos = new ArrayList<>();
		enderecos.add(endereco);
		condutor.setItinerario(enderecos);
	}

	private static void createUsuario(Usuario usuario, Endereco endereco) {
		usuario.setNome("Usuario");
		usuario.setLogin("usuario123");
		usuario.setPassword("1234");
		usuario.setEndereco(endereco);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endereco endereco = new Endereco();
		Coordenada coordenada = new Coordenada();
		Usuario usuario = new Usuario();
		Condutor condutor = new Condutor();
		createCoordenada(coordenada);
		createEndereco(endereco, coordenada);
		createUsuario(usuario, endereco);
		createCondutor(condutor, endereco);
		EntityManagerFactory emf = null;
		EntityManager emg = null;
		EntityTransaction ent = null;
		try{
			emf = Persistence.createEntityManagerFactory("Transporte");
			emg = emf.createEntityManager();
			ent = emg.getTransaction();
			ent.begin();
			emg.persist(coordenada);
			emg.persist(endereco);
			emg.persist(usuario);
			emg.persist(condutor);
			ent.commit();
		}catch (Exception e){
			e.printStackTrace();
			if (ent != null){
				ent.rollback();
			};
		}finally{
			if (emg != null){
				emg.close();
			}
			if (emf != null){
				emf.close();
			}
		}
	}

}
