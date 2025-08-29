class House {
    double totalCost; // Cost is common for all functionalities

    public House(double initialCost) {
        this.totalCost = initialCost;
    }

    public void displayTotalCost() {
        System.out.println("Total Cost of the House: $" + totalCost);
    }

    // Nested class for Construction
    public class Construction {
        double foundationCost;
        double wallsCost;
        double roofCost;

        public Construction(double foundationCost, double wallsCost, double roofCost) {
            this.foundationCost = foundationCost;
            this.wallsCost = wallsCost;
            this.roofCost = roofCost;
        }

        public double calculateConstructionCost() {
            return foundationCost + wallsCost + roofCost;
        }

        public void displayConstructionCost() {
            double cost = calculateConstructionCost();
            System.out.println("Construction Cost: $" + cost);
            totalCost += cost; // Update the total cost in the outer class
        }
    }

    // Nested class for Interior Decoration
    public class InteriorDecoration {
        double flooringCost;
        double paintingCost;
        double furnitureCost;

        public InteriorDecoration(double flooringCost, double paintingCost, double furnitureCost) {
            this.flooringCost = flooringCost;
            this.paintingCost = paintingCost;
            this.furnitureCost = furnitureCost;
        }

        public double calculateDecorationCost() {
            return flooringCost + paintingCost + furnitureCost;
        }

        public void displayDecorationCost() {
            double cost = calculateDecorationCost();
            System.out.println("Interior Decoration Cost: $" + cost);
            totalCost += cost; // Update the total cost in the outer class
        }
    }

    public static void main(String[] args) {
        // Assuming an initial land cost
        House myHouse = new House(50000);
        myHouse.displayTotalCost(); // Display initial cost

        // Construction details
        House.Construction construction = myHouse.new Construction(15000, 20000, 10000);
        construction.displayConstructionCost();

        // Interior decoration details
        House.InteriorDecoration decoration = myHouse.new InteriorDecoration(8000, 5000, 12000);
        decoration.displayDecorationCost();

        // Display the final total cost
        myHouse.displayTotalCost();
    }
}
