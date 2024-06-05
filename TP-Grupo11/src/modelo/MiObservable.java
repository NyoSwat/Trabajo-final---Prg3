package modelo;

import java.util.Observable;

public class MiObservable extends Observable{
	public void setChangedExternamente() {
        this.setChanged();
    }

}
