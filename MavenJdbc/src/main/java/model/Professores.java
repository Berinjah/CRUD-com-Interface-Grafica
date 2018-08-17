package model;

public class Professores extends Registros{
	
	private int rp; //Registro de professor
	private int rc; //Resgitro do coordenador responsável
	
	public int getRp() {
		return rp;
	}
	
	public void setRp(int rp) {
		this.rp = rp;
	}
	
	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

}