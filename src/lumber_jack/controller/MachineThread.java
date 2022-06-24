package lumber_jack.controller;

import lumber_jack.model.Machine;

public class MachineThread extends Thread {

    private Machine machine;
    protected float defaultTime =  5 * 1000;

    public MachineThread(Machine machine){
        this.machine = machine;
        System.out.println("start");
    }

    @Override
    public void run() {
        while(true) {
            int timeToProduce = calculateProduceTime();
            for(int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(timeToProduce/100);
                    timeToProduce = calculateProduceTime();
                } catch(Exception e) {}
            }
            machine.produce();
        }    
    }

    
    /** 
     * @return int
     */
    public int calculateProduceTime() {
        return (int)(defaultTime/machine.getSpeed());
    } 
}
