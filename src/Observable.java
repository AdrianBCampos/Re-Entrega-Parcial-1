import java.util.List;
import java.util.ArrayList;

class Observable {

    private List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
        System.out.println("Observador eliminado: " + observer);
    }



    public List<Observer> obtenerListaDeObservers() {
        return observers;
    }

    public void notifyObservers(Comision comisionObservada) {
        if (!observers.isEmpty()) {
            Observer firstObserver = observers.get(0);
            firstObserver.update(comisionObservada);
        }
    }

     /*private List<Observer> getObservers() {
        return observers;
    }*/



}
