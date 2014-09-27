
class StillWater extends Water{
	public function __construct($meta = 0){
		Liquid::__construct(self::STILL_WATER, $meta, "Still Water");
		$this->hardness = 500;
	}

}