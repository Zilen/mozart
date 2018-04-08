package acao.acorde;

import acao.Acao;
import entitade.Musica;
import entitade.acorde.ListaNota;

public class AcordesAcao extends Acao{

	public AcordesAcao(double chance, ListaNota acorde) {
		super(chance);
		this.acorde = acorde;
	}

	protected ListaNota acorde;
	
	@Override
	public void executar(Musica musica) {
		System.out.println("Acorde calculado: "+ this.acorde.getNome());
		musica.getAcordes().add(acorde);
		
	}
}
