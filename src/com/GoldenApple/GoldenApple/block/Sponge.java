

class Sponge extends Solid{
	public function __construct(){
		parent::__construct(self::SPONGE, "Sponge");
		$this->hardness = 3;
	}

}