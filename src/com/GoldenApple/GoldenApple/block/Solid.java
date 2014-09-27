

class Solid extends Generic{

	public function __construct($id, $meta = 0, $name = "Unknown"){
		parent::__construct($id, $meta, $name);
		$this->isSolid = true;
		$this->isFullBlock = true;
	}
}