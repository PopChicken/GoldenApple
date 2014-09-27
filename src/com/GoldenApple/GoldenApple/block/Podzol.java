
class Podzol extends Solid{
	public function __construct(){
		parent::__construct(self::PODZOL, 0, "Podzol");	
		$this->hardness = 2.5;
	}
}