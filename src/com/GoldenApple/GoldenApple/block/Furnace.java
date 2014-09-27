

class Furnace extends BurningFurnace{
	public function __construct($meta = 0){
		parent::__construct($meta);
		$this->id = self::FURNACE;
		$this->name = "Furnace";
		$this->isActivable = true;
	}
}