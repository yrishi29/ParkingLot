package org.example.parkinglot;

import org.example.parkinglot.controller.TicketController;
import org.example.parkinglot.dtos.IssueTicketRequestDTO;
import org.example.parkinglot.dtos.IssueTicketResponseDTO;
import org.example.parkinglot.models.*;
import org.example.parkinglot.models.enums.GateType;
import org.example.parkinglot.models.enums.SlotAllocationStrategyType;
import org.example.parkinglot.models.enums.VehicleType;
import org.example.parkinglot.repositories.GateRepository;
import org.example.parkinglot.repositories.ParkingLotRepository;
import org.example.parkinglot.repositories.TicketRepository;
import org.example.parkinglot.repositories.VehicleRepository;
import org.example.parkinglot.services.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ParkingLotApplication {

		public static void main(String[] args) {
			// Dependencies
			TicketRepository ticketRepository = new TicketRepository();
			GateRepository gateRepository = new GateRepository();
			ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
			VehicleRepository vehicleRepository = new VehicleRepository();

			TicketService ticketService = new TicketService(ticketRepository, gateRepository, vehicleRepository, parkingLotRepository);

			TicketController ticketController = new TicketController(ticketService);

			// populate the data
			initialiseDatabase(gateRepository, parkingLotRepository);



			// 1st Request
			IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
			requestDTO.setOwnerName("Rishi");
			requestDTO.setVehicleNumber("MH03AZ7775");
			requestDTO.setVehicleType(VehicleType.CAR);
			requestDTO.setGateId(1);

			// call the controller and get a response back
			System.out.println("-----------------------------------------------------------");
			IssueTicketResponseDTO responseDTO = ticketController.issueTicket(requestDTO);

			// deal with the response
			System.out.println(responseDTO.getTicketNumber());
			System.out.println("Entry Time --" + responseDTO.getEntryTime());
			System.out.println("Slot number --" + responseDTO.getParkingSlot().getSlotNumber());
			System.out.println(responseDTO.getResponseMessage());

			// 2nd request
			// Request
			requestDTO = new IssueTicketRequestDTO();
			requestDTO.setOwnerName("Saina");
			requestDTO.setVehicleNumber("MH03AZ8899");
			requestDTO.setVehicleType(VehicleType.CAR);
			requestDTO.setGateId(1);

			// call the controller and get a response back
			System.out.println("-----------------------------------------------------------");
			responseDTO = ticketController.issueTicket(requestDTO);

			// deal with the response

			System.out.println(responseDTO.getTicketNumber());
			System.out.println("Entry Time --" + responseDTO.getEntryTime());
			System.out.println("Slot number --" + responseDTO.getParkingSlot().getSlotNumber());
			System.out.println(responseDTO.getResponseMessage());



			requestDTO = new IssueTicketRequestDTO();
			requestDTO.setOwnerName("Rishikesh");
			requestDTO.setVehicleNumber("MH0775");
			requestDTO.setVehicleType(VehicleType.CAR);
			requestDTO.setGateId(1);

			System.out.println("-----------------------------------------------------------");
			responseDTO = ticketController.issueTicket(requestDTO);

			System.out.println(responseDTO.getTicketNumber());
			System.out.println("Entry Time --" + responseDTO.getEntryTime());
			System.out.println("Slot number --" + responseDTO.getParkingSlot().getSlotNumber());
			System.out.println(responseDTO.getResponseMessage());


		}

		private static void initialiseDatabase(GateRepository gateRepository, ParkingLotRepository parkingLotRepository){
			Operator entryGateOperator = new Operator("111", "op1");
			Operator exitGateOperator = new Operator("222", "op2");

			Gate gate1 = new Gate(1, entryGateOperator, GateType.ENTRY_GATE);
			Gate gate2 = new Gate(2, exitGateOperator, GateType.EXIT_GATE);

			List<Gate> gateList = new ArrayList<>();
			gateList.add(gate1);
			gateList.add(gate2);

			gateRepository.save(gate1);
			gateRepository.save(gate2);

			ParkingFloor floor1 = new ParkingFloor(1);

			floor1.getParkingSlotList().add(new ParkingSlot(101, VehicleType.CAR));
			floor1.getParkingSlotList().add(new ParkingSlot(102, VehicleType.CAR));

			ParkingFloor floor2 = new ParkingFloor(2);
			floor2.getParkingSlotList().add(new ParkingSlot(201, VehicleType.BIKE));
			floor2.getParkingSlotList().add(new ParkingSlot(202, VehicleType.BIKE));
			floor2.getParkingSlotList().add(new ParkingSlot(203, VehicleType.BIKE));
			ParkingFloor floor3 = new ParkingFloor(3);
			floor3.getParkingSlotList().add(new ParkingSlot(301, VehicleType.CAR));

			List<ParkingFloor> parkingFloorsList = new ArrayList<>();
			parkingFloorsList.add(floor1);
			parkingFloorsList.add(floor2);
			parkingFloorsList.add(floor3);

			ParkingLot parkingLot = new ParkingLot();
			parkingLot.setGates(gateList);
			parkingLot.setSlotAllocationStrategyType(SlotAllocationStrategyType.NEAREST_TO_GATE);
			parkingLot.setParkingFloors(parkingFloorsList);

			parkingLotRepository.save(parkingLot);
		}
	}


