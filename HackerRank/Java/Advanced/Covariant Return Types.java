//Complete the classes below
class Flower {
    public String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine extends Flower{
    @Override
    public String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower{
    @Override
    public String whatsYourName() {
        return "Lily";
    }
}

class Region {
    public Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBengal extends Region{
    @Override
    public Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class AndhraPradesh extends Region{
    @Override
    public Lily yourNationalFlower() {
        return new Lily();
    }
}