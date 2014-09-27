
class Air extends Transparent{
	public $isActivable = false;
	public $breakable = false;
	public $isFlowable = true;
	public $isTransparent = true;
	public $isReplaceable = true;
	public $isPlaceable = false;
	public $hasPhysics = false;
	public $isSolid = false;
	public $isFullBlock = true;
	protected $id = self::AIR;
	protected $meta = 0;
	protected $name = "Air";
	protected $hardness = 0;

	public function __construct(){

	}

	public function getBoundingBox(){
		return null;
	}

}