package builder;


abstract class House
{
	private Floor floor;
	private Wall westWall;
	private Wall eastWall;
	private Wall southWall;
	private Wall northWall;
	private Roof roof;
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	public Wall getWestWall() {
		return westWall;
	}
	public void setWestWall(Wall westWall) {
		this.westWall = westWall;
	}
	public Wall getEastWall() {
		return eastWall;
	}
	public void setEastWall(Wall eastWall) {
		this.eastWall = eastWall;
	}
	public Wall getSouthWall() {
		return southWall;
	}
	public void setSouthWall(Wall southWall) {
		this.southWall = southWall;
	}
	public Wall getNorthWall() {
		return northWall;
	}
	public void setNorthWall(Wall northWall) {
		this.northWall = northWall;
	}
	public Roof getRoof() {
		return roof;
	}
	public void setRoof(Roof roof) {
		this.roof = roof;
	}

}

class Duplex extends House{}

class HUDHouse extends House{}

abstract class Floor{}
class CementFloor extends Floor{}
class SlabFloor extends Floor{}

abstract class Wall{}
class CementBlockWall extends  Wall{}
class WoodenWall extends Wall{}

abstract class Roof{}
class ShingledRoof extends Roof{}

abstract class HouseBuilder
{
	public abstract House CreateHouse();
	public abstract Floor CreateFloor();
	public abstract Wall CreateWall();
	public abstract Roof CreateRoof();
}

class DuplexBuilder extends HouseBuilder
{
	public  House CreateHouse()
	{
		return new Duplex();
	}
	public  Floor CreateFloor()
	{
		return new CementFloor();
	}
	public  Wall CreateWall()
	{
		return new CementBlockWall();
	}
	public  Roof CreateRoof()
	{
		return new ShingledRoof();
	}
}

class HUDBuilder extends HouseBuilder
{
	public  House CreateHouse()
	{
		return new HUDHouse();
	}
	public  Floor CreateFloor()
	{
		return new SlabFloor();
	}
	public  Wall CreateWall()
	{
		return new WoodenWall();
	}
	public  Roof CreateRoof()
	{
		return new ShingledRoof();
	}
}

class HouseDirector
{
	public House Construct(HouseBuilder builder)
	{
		House house  = builder.CreateHouse();
		house.setFloor(builder.CreateFloor());
		house.setEastWall (builder.CreateWall());
		house.setWestWall ( builder.CreateWall());
		house.setSouthWall ( builder.CreateWall());
		house.setNorthWall ( builder.CreateWall());
		house.setRoof (builder.CreateRoof());
		return house;
	}
}

public class Bulider {

	public static void main(String[] args) {
		HouseDirector director = new HouseDirector();
		House duplex = director.Construct(new DuplexBuilder());

		House hud = director.Construct(new HUDBuilder());
		
	}
}
