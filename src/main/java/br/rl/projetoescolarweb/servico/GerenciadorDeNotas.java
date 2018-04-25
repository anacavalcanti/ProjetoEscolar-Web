package br.rl.projetoescolarweb.servico;


import br.rl.projetoescolarweb.modelo.Nota;

public class GerenciadorDeNotas {
	
	public boolean setarNota(Nota nota) {
		
		if(nota.getValor() < 0 || nota.getValor() > 10) {
			return false;
		}else if(nota.getDisciplina() == null || nota.getAluno() == null) {
			return false;	
		}else {
			return true;
		}
	}
	
}
