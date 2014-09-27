

class Snow extends Solid{
	public function __construct(){
		parent::__construct(self::SNOW_BLOCK, 0, "Snow Block");
		$this->hardness = 1;
	}

}