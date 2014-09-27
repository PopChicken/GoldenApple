

class Sand extends Fallable{
	public function __construct($meta = 0){
		parent::__construct(self::SAND, $meta & 0x01, "Sand");
		if($this->meta === 0x01){
			$this->name = "Red sand";
		}
		$this->hardness = 2.5;
	}

}