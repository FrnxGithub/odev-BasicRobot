
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class Robot extends TimedRobot {
  private TalonSRX SolOnMotor, SolArkaMotor, SagOnMotor, SagArkaMotor;
  private Joystick kumanda;
  private CANSparkMax neoMotor;
  private boolean neoMotorDurum = false;


  @Override
  public void robotInit() {
    kumanda = new Joystick(0);
    SolOnMotor = new TalonSRX(1);
    SolArkaMotor = new TalonSRX(2);
    SagOnMotor = new TalonSRX(3);
    SagArkaMotor = new TalonSRX(4);
    neoMotor = new CANSparkMax(5, MotorType.kBrushless); //
  }


  @Override
  public void robotPeriodic() {} // Robot çalıştığı vakit boyunca yapılacaklar:

  @Override
  public void autonomousInit() { // Otonom başladığında bir kere yapılacak işlemler
  }


  @Override
  public void autonomousPeriodic() { // Robot otonomda olduğu vakitte yapılacak işlemler:
  }

  
  @Override
  public void teleopInit() {

  } // Teleop başlamadan önce bir kere yapılcak işlemler

  
  @Override
  public void teleopPeriodic() { // Teleop başladğında yapılcak işlemler
    // Kumanda verilerini ayarlıyoz
    double SolHiz = kumanda.getRawAxis(1);
    double SagHiz = kumanda.getRawAxis(5);


    boolean besinciDugme = kumanda.getRawButton(3); // 5. düğme kontrolü

        if (besinciDugme && !neoMotorDurum) {
            neoMotor.set(1.0); // Motoru aç
            neoMotorDurum = true; // Motor durumunu güncelle
            System.out.println("NeoMotor açık");
        } else if (besinciDugme && neoMotorDurum) {
            neoMotor.set(0.0); // Motoru kapat
            neoMotorDurum = false; // Motor durumunu güncelle
            System.out.println("Neo Motor kapalı");
        }

    SolOnMotor.set(ControlMode.PercentOutput, SolHiz);
    SolArkaMotor.set(ControlMode.PercentOutput, SolHiz);
    SagOnMotor.set(ControlMode.PercentOutput, SagHiz);
    SagArkaMotor.set(ControlMode.PercentOutput, SagHiz);

        // Motor hızlarını konsola yazdırıyoruz
        //System.out.println("Sol Motorlar: " + SolHiz);
        //System.out.println("Sağ Motorlar: " + SagHiz);


  } 

  @Override
  public void disabledInit() { // Robot devre dışı bırakdığında bir kere yapılcak işlemler

  }


  @Override
  public void disabledPeriodic() { // Robot devre dışı olduğu sürece yapılacak işlemler

  }

  
  @Override
  public void testInit() { // Test modu başladığında bir kere yapılacka işlemler

  }


  @Override
  public void testPeriodic() { // Test modu boyunca yapılacak işlemler

  }


  @Override
  public void simulationInit() { // Simülasyon başladığında bir kere yapılacak işlemler

  }


  @Override
  public void simulationPeriodic() { // Simülasyon sürerken yapılacak işlemler

  }
}
