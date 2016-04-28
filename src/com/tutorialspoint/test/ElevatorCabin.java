package com.tutorialspoint.test;

import java.util.TreeSet;

public class ElevatorCabin {
	public int currentFloor = 0;
	public UpDownEnum direction = UpDownEnum.UP;
	public TreeSet<Integer> callingFloorList = new TreeSet<Integer>();

	public void add(Integer floor) {
		callingFloorList.add(floor);
	}
	public Integer gotoNext(){
		Integer nextFloor = currentFloor;
		switch(direction){
		/*initially it will go up as it's in basement*/
		case UP:
			for(Integer floor: callingFloorList){
				/*if next floor is above the current floor the it will move upward*/
				if(floor>nextFloor){
					nextFloor=floor;
					direction=UpDownEnum.UP;
					break;
				}
			}
			//if reached the desired floor
			if(nextFloor==currentFloor){
				for(Integer floor: callingFloorList.descendingSet()){
					if(floor<nextFloor){
						nextFloor=floor;
						direction=UpDownEnum.DOWN;
						break;
					}
				}
			}
			break;
		case DOWN:
			/*if next floor is down the current floor the it will move upward*/
			for (Integer floor : callingFloorList.descendingSet()) {
                if(floor < nextFloor){
                    nextFloor = floor;
                    direction = UpDownEnum.DOWN;
                    break;
                }
            }
			//if reached the desired floor
			if(nextFloor == currentFloor){
                for (Integer floor : callingFloorList) {
                    if(floor > nextFloor){
                        nextFloor = floor;
                        direction = UpDownEnum.UP;
                        break;
                    }
                }
            }
		}
		 callingFloorList.remove(nextFloor);
	     currentFloor = nextFloor;
		return nextFloor;
	}
}
